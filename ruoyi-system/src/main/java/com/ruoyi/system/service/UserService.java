package com.ruoyi.system.service;

import com.ruoyi.system.domain.User;
import com.ruoyi.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User authenticate(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = userMapper.selectByUsername(username);
        if (user != null && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            userMapper.updateUser(user);
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    public int getTotalUsers() {
        return userMapper.selectTotalUsers();
    }
}
