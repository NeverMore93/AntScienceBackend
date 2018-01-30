package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.UserDao;
import com.as.backend.antscience.dto.LoginUser;
import com.as.backend.antscience.dto.UserDto;
import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void createUser(User user) {
        userDao.saveAndFlush(user);
    }

    public User findUserByIdentity(String identity) {
        User user = userDao.findUsersByUsernameOrEmailOrPhone(identity,identity,identity);
        if(Objects.nonNull(user)){
            return userDao.findUsersByUsernameOrEmailOrPhone(identity,identity,identity);
        }else {
            throw new UserNotFoundException("用户不存在");
        }
    }

    @Override
    public UserDto login(LoginUser loginUser) {
        User user = findUserByIdentity(loginUser.getIdentity());
        if(loginUser.getPassword().equals(user.getPassword())){
            return User2UserDto(user);
        }else {
            throw new UserNotFoundException("用户密码有误");
        }
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

    private UserDto User2UserDto(User user){
        return new UserDto(user.getId(),user.getUsername(),user.getPhone(),user.getEmail(),user.getGender());
    }
}
