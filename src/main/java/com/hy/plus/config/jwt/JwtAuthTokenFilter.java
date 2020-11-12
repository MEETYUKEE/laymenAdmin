package com.hy.plus.config.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * <p>
 *  鉴权拦截器
 * </p>
 * @author hy
 * @date 2020/11/11 16:08
 **/
@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(jwtUtils.getHeader());
        if (!StringUtils.isEmpty(token)){
            String authToken = token.replace("Bearer ", "");
            Claims claims = jwtUtils.getClaimsFromToken(authToken);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (null != claims && null == authentication){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername((String) claims.get("name"));
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);

    }
}
