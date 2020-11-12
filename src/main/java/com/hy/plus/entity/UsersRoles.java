package com.hy.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/***
 * <p>
 *  客户角色关联表
 * </p>
 * @author hy
 * @date 2020/11/10 17:29
 **/
@Data
@TableName("users_roles")
public class UsersRoles implements Serializable {

    @ApiModelProperty("客户ID")
    private Long usersId;

    @ApiModelProperty("角色ID")
    private Long rolesId;

}
