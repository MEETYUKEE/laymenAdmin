package com.hy.plus.config.security;

import com.hy.plus.config.jwt.JwtAuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/***
 * <p>
 * Spring security 配置类
 * see @EnableGlobalMethodSecurity 该注解开启spring security 方法注解。 prePostEnabled 设置后true后，支持Spring EL表达式
 * </p>
 * @author hy
 * @date 2020/11/10 15:10
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtAuthTokenFilter jwtAuthTokenFilter;
    @Resource
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Resource
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class)
          .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .accessDeniedHandler(jwtAccessDeniedHandler).and()
          // 不创建 session 会话。 如果创建 session 会话，请求需要校验的接口后就不能再次获取token
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
          .authorizeRequests()
          .antMatchers(HttpMethod.POST, "/auth/api/login").anonymous()
          // 静态资源等等
          .antMatchers(
                HttpMethod.GET,
                "/*.html",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/webSocket/**"
          ).permitAll()
          .antMatchers("/swagger-ui/index.html", "/swagger-resources/**", "/*/api-docs").permitAll()
          .anyRequest()
          .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
