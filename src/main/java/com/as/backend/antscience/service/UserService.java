package com.as.backend.antscience.service;

import com.as.backend.antscience.entity.User;

public interface UserService {
    User findUserByUsername(String username);
}
