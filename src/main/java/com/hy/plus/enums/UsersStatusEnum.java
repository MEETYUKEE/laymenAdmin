package com.hy.plus.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * <p>
 *  客户状态枚举类
 * </p>
 * @author hy
 * @date 2020/11/10 17:20
 **/
@Getter
@AllArgsConstructor
public enum UsersStatusEnum {
    /**
     * 描述
     */
    EFFECTIVE(0, "有效"),
    TO_VOID(1, "作废"),
    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态描述
     */
    private final String status;

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return {@link UsersStatusEnum } 实例
     **/
    public static UsersStatusEnum find(Integer code) {
        for (UsersStatusEnum instance : UsersStatusEnum.values()) {
            if (instance.getCode().equals(code)) {
                return instance;
            }
        }
        return null;
    }


}
