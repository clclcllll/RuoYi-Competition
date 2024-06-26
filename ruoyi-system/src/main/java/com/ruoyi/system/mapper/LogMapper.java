package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Log;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    int insertLog(Log log);
    List<Log> selectAllLogs();
    List<Log> selectLogsByUserId(Integer userId);
}
