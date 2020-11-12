package com.hy.plus.controller;

import com.hy.plus.service.UsersService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * <p>
 *  用户控制器
 * </p>
 * @author hy
 * @date 2020/11/11 16:49
 **/
@Api(tags = "用户管理")
@RestController
@RequestMapping("user")
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("user")
    @PreAuthorize("hasAnyRole('ROLE_user')")
    public ResponseEntity<Object> findAllUser(@RequestParam String userName){
        return ResponseEntity.ok(usersService.findByUserName(userName));
    }

    @GetMapping("admin")
    @PreAuthorize("hasAnyRole('ROLE_admin')")
    public ResponseEntity<Object> findAllAdmin(@RequestParam String userName){
        return ResponseEntity.ok(usersService.findByUserName(userName));
    }

}
