package com.as.backend.antscience.security;

import lombok.Data;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

@Data
public class DefaultUsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {

    //identity
    private Object principal;
    //password
    private Object credentials;


    public DefaultUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    public DefaultUsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
            super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true); // must use super, as we override
    }


    @Override
    public Object getPrincipal() {
        return null;
    }
}
