package com.hy;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.hy.plus.util.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.hy.**.mapper")
public class MybatisPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemoApplication.class, args);
    }

    /****
     * 乐观锁配置
     * @return 、
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /***
     * 注册 SpringContextHolder
     * @return \
     */
    @Bean
    public SpringContextHolder springContextHolder(){
        return new SpringContextHolder();
    }
}
