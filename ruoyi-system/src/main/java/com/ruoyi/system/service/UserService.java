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
        return userMapper.selectByUsername(username);
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return userMapper.changePassword(username, oldPassword, newPassword) > 0;
    }

    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    public int getTotalUsers() {
        return 0;
    }

    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    public boolean deleteUserById(int id) {
        return userMapper.deleteUserById(id) > 0;
    }

    public boolean createUser(User user) {
        return userMapper.insertUser(user) > 0;
    }
}
