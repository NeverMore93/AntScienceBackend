package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.UserDao;
import com.as.backend.antscience.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void createUser(User user) {
        userDao.saveAndFlush(user);
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
}
