package com.as.backend.antscience.service;

import com.as.backend.antscience.dto.LoginUser;
import com.as.backend.antscience.dto.RegisterUserDto;
import com.as.backend.antscience.dto.UserDto;
import com.as.backend.antscience.entity.User;

public interface UserService {
    User findUserByUsername(String username);
    Long getUserIdByUserName(String username);
    void createUser(User user);
    User findUserByIdentity(String identity);
    UserDto login(LoginUser loginUser);
    UserDto register(RegisterUserDto registerUserDto);
}
