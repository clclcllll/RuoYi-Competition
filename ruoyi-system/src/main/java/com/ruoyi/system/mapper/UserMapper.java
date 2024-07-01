package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    User selectByUsername(String username);
    int changePassword(String username, String oldPassword, String newPassword);
    List<User> selectAllUsers();
    int insertUser(User user);
    int updateUser(User user);
    int deleteUserById(int userId);

    User selectById(int id);

    boolean register(String username, String password, String role, String name, String contactInfo);

    void approveRegistration(int userId);
}
