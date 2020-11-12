package com.hy.plus.controller;

import com.hy.plus.config.jwt.JwtAuthService;
import com.hy.plus.vo.AuthenticationRequestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * <p>
 *  认证控制器
 * </p>
 * @author hy
 * @date 2020/11/11 15:04
 **/
@Api(tags = "登录认证")
@RestController
@RequestMapping("auth/api")
public class AuthenticationController {

    @Resource
    private JwtAuthService jwtAuthService;

    @ApiOperation("登录认证接口")
    @PostMapping("login")
    public ResponseEntity<Object> auth(@RequestBody @Validated AuthenticationRequestVo requestVo){
        return jwtAuthService.auth(requestVo);
    }



}
