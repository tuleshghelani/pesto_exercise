package com.tulesh.springboot.config;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tulesh.springboot.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String username;
    private User users;
    private Long selectedUserRoleId;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(User users, String username, String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.users = users;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public UserPrincipal(
            User users, String username, String password,
            Collection<? extends GrantedAuthority> authorities, Long selectedUserRoleId
    ) {
        this.users = users;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.selectedUserRoleId = selectedUserRoleId;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new UserPrincipal(user, user.getUsername(), user.getPassword(), authorities);
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getSelectedUserRoleId() {
        return selectedUserRoleId;
    }

    public void setSelectedUserRoleId(Long selectedUserRoleId) {
        this.selectedUserRoleId = selectedUserRoleId;
    }


    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    public User getUser() {
        return users;
    }

    public void setUser(User users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((users == null) ? 0 : users.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserPrincipal other = (UserPrincipal) obj;
        if (authorities == null) {
            if (other.authorities != null)
                return false;
        } else if (!authorities.equals(other.authorities))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (users == null) {
            if (other.users != null)
                return false;
        } else if (!users.equals(other.users))
            return false;
        return true;
    }

}

