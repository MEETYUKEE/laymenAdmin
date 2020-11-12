package com.hy.plus.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/***
 * <p>
 *  登录请求接口
 * </p>
 * @author hy
 * @date 2020/10/12 18:43
 **/
@Data
public class AuthenticationRequestVo implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

}
