package com.todo.user;

import com.todo.utils.ToDoConstants;
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

        if(username.equals(ToDoConstants.DEFAULT_USERNAME) && user==null){
            return createDefaultUser(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    private CustomUserDetails createDefaultUser(String username) {
        CustomUserDetails userAdmin = new CustomUserDetails(username, new BCryptPasswordEncoder(11)
                                                                        .encode(ToDoConstants.DEFAULT_PASSWORD));
        userRepository.save(userAdmin);

        return userAdmin;
    }
}