package com.hy.plus.config.security;

import com.hy.plus.service.UsersService;
import com.hy.plus.vo.UsersVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * <p>
 *  spring security 认证
 * </p>
 * @author hy
 * @date 2020/11/10 19:49
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersVo usersVo = usersService.findByUserName(username);
        if (null == usersVo){
            throw new UsernameNotFoundException("登录用户：" + username + "不存在");
        }
        return usersVo;

    }
}
