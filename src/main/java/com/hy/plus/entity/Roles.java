package com.hy.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/***
 * <p>
 *  角色表
 * </p>
 * @author hy
 * @date 2020/11/10 17:25
 **/
@Data
@TableName("roles")
public class Roles implements Serializable {

    @ApiModelProperty("角色ID")
    @TableId(type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色别名")
    private String roleAlias;

    @ApiModelProperty("创建时间")
    private Timestamp createDate;

}
