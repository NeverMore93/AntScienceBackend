package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.UserDao;
import com.as.backend.antscience.dto.LoginUser;
import com.as.backend.antscience.dto.UserDto;
import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.enums.Authority;
import com.as.backend.antscience.exceptions.UserExistedException;
import com.as.backend.antscience.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private TokenService tokenService;

    private String[] authorities = {Authority.GENERAL.toString()};

    public void createUser(User user) {
        userDao.saveAndFlush(user);
    }

    public User findUserByIdentity(String identity) {
        User user = userDao.findUsersByUsernameOrEmailOrPhone(identity, identity, identity);
        if (!Objects.nonNull(user)) {
            throw new UserNotFoundException("用户不存在");
        }
        return userDao.findUsersByUsernameOrEmailOrPhone(identity, identity, identity);
    }

    @Override
    public UserDto login(LoginUser loginUser) {
        User user = findUserByIdentity(loginUser.getIdentity());
        if (!loginUser.getPassword().equals(user.getPassword())) {
            throw new UserNotFoundException("用户密码有误");
        }
        return User2UserDto(user);
    }

    @Override
    public User register(LoginUser loginUser) {
        String identity = loginUser.getIdentity();
        User foundUser = userDao.findUsersByUsernameOrEmailOrPhone(identity, identity, identity);
        if (Objects.nonNull(foundUser)){
            throw new UserExistedException("用户已经存在");
        }
        User user = new User();
        user.setUsername(identity);
        user.setPassword(loginUser.getPassword());
        user.setRoles(authorities);
        userDao.saveAndFlush(user);
        return userDao.findUserByUsername(loginUser.getIdentity());
    }

    public void updateUser(User user) {
    }


    public void deleteUser(String username) {

    }

    public void changePassword(String oldPassword, String newPassword) {

    }


    public boolean userExists(String username) {
        return false;
    }


    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public Long getUserIdByUserName(String username) {
        return findUserByUsername(username).getId();
    }

    private UserDto User2UserDto(User user) {
        String token = tokenService.buildToken(user.getUsername());
        return new UserDto(user.getId(), user.getUsername(), user.getPhone(), user.getEmail(), user.getGender(), token);
    }
}
