package com.todo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<CustomUserDetails, Long> {

    CustomUserDetails findByUsername(String username);
}