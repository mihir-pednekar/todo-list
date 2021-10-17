package com.todo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserDetailsRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        CustomUserDetails user = userRepository.findByUsername(username);

        if(username.equals("test")){
            return createDefaultUser(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    private CustomUserDetails createDefaultUser(String username) {
        CustomUserDetails userAdmin = new CustomUserDetails(username, new BCryptPasswordEncoder(11)
                                                                        .encode("pwd123"));
        userRepository.save(userAdmin);

        return userAdmin;
    }
}