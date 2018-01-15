package com.as.backend.antscience.service;

import com.as.backend.antscience.entity.User;
import org.springframework.security.provisioning.UserDetailsManager;

public interface UserService extends UserDetailsManager {
    User findUserByUsername(String username);
    Long getUserIdByUserName(String username);
}
