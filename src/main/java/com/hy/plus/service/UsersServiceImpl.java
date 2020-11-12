package com.hy.plus.service;

import com.hy.plus.mapper.UsersMapper;
import com.hy.plus.vo.UsersVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * <p>
 *  客户 service 实现类
 * </p>
 * @author hy
 * @date 2020/11/10 18:52
 **/
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UsersVo findByUserName(String userName) {
        return usersMapper.findByUserName(userName);
    }
}
