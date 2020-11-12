package com.hy.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/***
 * <p>
 *  用户表
 * </p>
 * @author hy
 * @date 2020/11/10 17:17
 **/
@Data
@TableName("users")
public class Users implements Serializable {

    @ApiModelProperty("客户ID")
    @TableId(type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("客户名称")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态。 默认 0. 0 -> 有效 1 -> 作废")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Timestamp createDate;

}
