package com.hy.plus.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * <p>
 * Swagger 配置类
 * </p>
 * @author hy
 * @date 2020/10/20 15:04
 **/
@Component
@ConfigurationProperties("swagger")
@Data
public class SwaggerProperties {

    /*** 是否开启swagger， 生成环境一般关闭，所以这里设置为变量*/
    private Boolean enable;

    /*** 项目应用名*/
    private String applicationName;

    /*** 项目版本信息*/
    private String applicationVersion;

    /*** 项目描述信息*/
    private String applicationDescription;

    /*** 接口调试地址*/
    private String tryHost;

    /*** token 请求头参数名*/
    private String tokenHeader;

}
