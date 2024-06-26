package com.ruoyi.system;

import com.ruoyi.system.domain.Log;
import com.ruoyi.system.service.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LogServiceTest {

    @Autowired
    private LogService logService;

    @Test
    public void testCreateLog() {
        Log log = new Log();
        log.setUserId(1);
        log.setOperation("Test Operation");

        int result = logService.createLog(log);
        assertEquals(1, result);
    }

    @Test
    public void testGetAllLogs() {
        List<Log> logs = logService.getAllLogs();
        assertNotNull(logs);
        assertTrue(logs.size() > 0);
    }
}
