package com.hy.plus.service;

import com.hy.plus.vo.UsersVo;

/***
 * <p>
 *  客户 service
 * </p>
 * @author hy
 * @date 2020/11/10 18:52
 **/
public interface UsersService {

    /***
     * 根据客户名称查询客户信息
     * @param userName 、
     * @return 、
     */
    UsersVo findByUserName(String userName);

}
