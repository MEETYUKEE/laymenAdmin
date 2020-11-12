package com.hy.plus.config.jwt;

import com.hy.plus.entity.Users;
import com.hy.plus.enums.UserTokenTypeEnum;
import com.hy.plus.vo.AuthVo;
import com.hy.plus.vo.AuthenticationRequestVo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/***
 * <p>
 * JWT 认证 service 实现类
 * </p>
 * @author hy
 * @date 2020/11/11 15:08
 **/
@Service
public class JwtAuthServiceImpl implements JwtAuthService{

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<Object> auth(AuthenticationRequestVo requestVo) {
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestVo.getUsername(),
                    requestVo.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("用户名密码错误");
        }
        Users users = (Users) authenticate.getPrincipal();
        Map<String, Object> map = new HashMap<>(4);
        map.put("id", users.getId());
        map.put("name", users.getUserName());
        map.put("status", users.getStatus());
        map.put("date", users.getCreateDate());
        // 生成token
        String jwt = jwtUtils.createJwt(users.getUserName(), UserTokenTypeEnum.USER.getType(), map);
        return ResponseEntity.ok(AuthVo.builder()
                .id(users.getId())
                .userName(users.getUserName())
                .status(users.getStatus())
                .createDate(users.getCreateDate())
                .token(jwt)
                .build());
    }
}
