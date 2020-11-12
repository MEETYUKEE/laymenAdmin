package com.hy.plus.vo;

import com.hy.plus.entity.Users;
import com.hy.plus.enums.UsersStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/***
 * <p>
 *  用户表VO
 * </p>
 * @author hy
 * @date 2020/11/10 19:26
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class UsersVo extends Users implements UserDetails, Serializable {

    /*** 角色*/
    private Set<String> roles;

    /*** 权限*/
    private Set<String> permission;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> permission = getPermission();
        return CollectionUtils.isEmpty(permission) ? null : getGrantedAuthorities(permission);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return UsersStatusEnum.EFFECTIVE.getCode().equals(getStatus());
    }

    private Set<GrantedAuthority> getGrantedAuthorities(final Set<String> privileges) {
        final Set<GrantedAuthority> authorities = new HashSet<>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
