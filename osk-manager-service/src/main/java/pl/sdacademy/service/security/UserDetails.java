package pl.sdacademy.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserDetails extends User {

    private final Long accountId;

    public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long accountId) {
        super(username, password, authorities);
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
