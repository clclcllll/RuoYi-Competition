package com.ruoyi.system.service;

import com.ruoyi.system.domain.Log;
import com.ruoyi.system.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogMapper logMapper;

    public List<Log> getAllLogs() {
        return logMapper.selectAllLogs();
    }

    public boolean createLog(Log log) {
        return logMapper.insertLog(log) > 0;
    }

    public boolean deleteLogById(int id) {
        return logMapper.deleteLogById(id) > 0;
    }
}
