package com.hy.plus.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * <p>
 *  用户token 类型
 * </p>
 * @author hy
 * @date 2020/11/11 15:57
 **/
@Getter
@AllArgsConstructor
public enum UserTokenTypeEnum {
    /**
     * 描述
     */
    USER(1, "USER"),
    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态描述
     */
    private final String type;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link UserTokenTypeEnum } 实例
     **/
    public static UserTokenTypeEnum find(Integer code) {
        for (UserTokenTypeEnum instance : UserTokenTypeEnum.values()) {
            if (instance.getCode().equals(code)) {
                return instance;
            }
        }
        return null;
    }


}
