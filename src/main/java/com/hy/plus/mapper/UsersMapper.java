package com.hy.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.plus.entity.Users;
import com.hy.plus.vo.UsersVo;
import org.apache.ibatis.annotations.Param;

/***
 * <p>
 *  用户表 mapper
 * </p>
 * @author hy
 * @date 2020/11/10 18:38
 **/
public interface UsersMapper extends BaseMapper<Users> {

    /***
     * 根据客户名称查询客户信息。   注： 该方法仅供登录验证时使用。 单独执行sq 存在笛卡尔积问题
     * @param userName 、 用户名
     * @return 、
     */
    UsersVo findByUserName(@Param("userName") String userName);

}
