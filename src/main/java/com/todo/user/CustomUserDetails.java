package com.todo.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private String password;

    private String username;

    @ElementCollection
    private Set<GrantedAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public CustomUserDetails() {
    }

    public CustomUserDetails(String username, String password) {
        if(username.equals("test")){
            this.username = username;
            this.password = password;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(username.equals("test")){
            Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
            authoritySet.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            this.authorities = Collections.unmodifiableSet(authoritySet);
            return Collections.unmodifiableSet(authoritySet);
        }
        else{
            Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
            authoritySet.add(new SimpleGrantedAuthority("ROLE_USER"));
            this.authorities = Collections.unmodifiableSet(authoritySet);
            return Collections.unmodifiableSet(authoritySet);
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
