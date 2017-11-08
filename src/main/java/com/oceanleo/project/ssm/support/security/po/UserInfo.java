package com.oceanleo.project.ssm.support.security.po;

import com.oceanleo.project.ssm.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * spring security 基本信息
 *
 * @author haiyang.li on 2017/7/12.
 */
public class UserInfo extends CurrentUser implements UserDetails,CredentialsContainer{

    private final String username;
    private String password;
    private static final boolean ACCOUNT_NON_EXPIRED = true;
    private static final boolean ACCOUNT_NON_LOCKED = true;
    private static final boolean CREDENTIALS_NON_EXPIRED = true;
    private boolean enabled = true;
    private final Set<GrantedAuthority> authorities;


    public UserInfo(String username,String password, boolean enabled, Set<GrantedAuthority> authorities,User user) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        BeanUtils.copyProperties(user,this);
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        return sortedAuthorities;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            if (g2.getAuthority() == null) {return -1;}
            if (g1.getAuthority() == null) {return 1;}
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.ACCOUNT_NON_EXPIRED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.ACCOUNT_NON_LOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.CREDENTIALS_NON_EXPIRED;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object rhs) {
        return rhs instanceof UserInfo&&username.equals(((UserInfo) rhs).username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }


}
