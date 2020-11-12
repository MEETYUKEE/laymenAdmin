package com.hy.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/***
 * <p>
 * 角色-权限关联表
 * </p>
 * @author hy
 * @date 2020/11/10 17:31
 **/
@Data
@TableName("roles_permission")
public class RolesPermission implements Serializable {

    @ApiModelProperty("角色ID")
    private Long rolesId;

    @ApiModelProperty("权限ID")
    private Long permissionId;

}
