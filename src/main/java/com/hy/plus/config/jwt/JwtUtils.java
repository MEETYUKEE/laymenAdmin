package com.hy.plus.config.jwt;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/***
 * <p>
 *  jwt token 工具类
 * </p>
 * @author hy
 * @date 2020/11/11 15:17
 **/
@Getter
@Setter
@Component
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    /** 签名私钥*/
    @Value("${secret:YpIVOjS198RcEpnt1Uo913pcCf7l1Ihfz3Olx4o}")
    private String secret;

    /** 前面有效时间. 默认两周*/
    @Value("${expiration-time:1209600}")
    private Long expirationTime;

    /** 前面有效时间. 默认两周*/
    @Value("${header:null}")
    private String header;

    /**
     * 从token中获取claim
     *
     * @param token token
     * @return claim
     */
    public Claims getClaimsFromToken(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            log.error("token解析错误", e);
            throw new IllegalArgumentException("Token invalided.");
        }
    }

    /**
     * 获取token的过期时间
     *
     * @param token token
     * @return 过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token)
                .getExpiration();
    }

    /**
     * 判断token是否过期
     *
     * @param token token
     * @return 已过期返回true，未过期返回false
     */
    private Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 计算token的过期时间
     *
     * @return 过期时间
     */
    private Date getExpirationTime() {
        return new Date(System.currentTimeMillis() + expirationTime * 1000);
    }

    /**
     * 设置认证token
     *      id:登录用户id
     *      subject：登录用户名
     *
     */
    public String createJwt(String id, String name, Map<String,Object> map) {
        //2.创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
                .setClaims(map)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret);
        //3.根据map设置claims
        jwtBuilder.setExpiration(getExpirationTime());
        return jwtBuilder.compact();
    }

    /**
     * 判断token是否非法
     *
     * @param token token
     * @return 未过期返回true，否则返回false
     */
    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

}
