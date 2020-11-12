package com.hy.plus.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/***
 * <p>
 * 登录验证token vo
 * </p>
 * @author hy
 * @date 2020/11/11 16:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthVo implements Serializable {

    @ApiModelProperty("客户ID")
    @TableId(type = IdType.INPUT)
    private Long id;

    @ApiModelProperty("客户名称")
    private String userName;

    @ApiModelProperty("状态。 默认 0. 0 -> 有效 1 -> 作废")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Timestamp createDate;

    @ApiModelProperty("创建时间")
    private String token;

}
