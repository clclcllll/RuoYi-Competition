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

    public boolean updateUser(int id, User user) {
        return userMapper.updateUser(user) > 0;
    }

    public boolean deleteUserById(int id) {
        return userMapper.deleteUserById(id) > 0;
    }

    public boolean createUser(User user) {
        return userMapper.insertUser(user) > 0;
    }
    //register
    public boolean register(String username, String password, String role, String name, String contactInfo) {
        return userMapper.register(username, password, role, name, contactInfo);
    }

    public List<User> getAllPendingRegistrations() {
        return null;
    }
    //approve registration
    public void approveRegistration(int userId) {
        userMapper.approveRegistration(userId);
    }
}
