package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Log;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface LogMapper {
    List<Log> selectAllLogs();
    int insertLog(Log log);
    int deleteLogById(int logId);
}
