package com.hy.plus.config.jwt;

import com.hy.plus.vo.AuthenticationRequestVo;
import org.springframework.http.ResponseEntity;

/***
 * <p>
 *  JWT 认证 service
 * </p>
 * @author hy
 * @date 2020/11/11 15:03
 **/
public interface JwtAuthService {

    /***
     * 登录认证、
     * @param requestVo 账户密码
     * @return 、
     */
    ResponseEntity<Object> auth(AuthenticationRequestVo requestVo);

}
