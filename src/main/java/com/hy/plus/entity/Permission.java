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
 *  权限表
 * </p>
 * @author hy
 * @date 2020/11/10 17:28
 **/
@Data
@TableName("permission")
public class Permission implements Serializable {

    @ApiModelProperty("权限ID")
    @TableId(type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("权限名称")
    private String permissionName;

    @ApiModelProperty("权限别名")
    private String permissionAlias;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("创建时间")
    private Timestamp createDate;
}
