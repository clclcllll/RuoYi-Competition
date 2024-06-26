package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByUsername(String username);
    int insertUser(User user);
    int updateUser(User user);
    User selectUserById(Integer userId);
    List<User> selectAllUsers();

    int selectTotalUsers();
}
