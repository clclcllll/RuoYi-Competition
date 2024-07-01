package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.Log;
import com.ruoyi.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public ResponseEntity<?> createLog(@RequestBody Log log) {
        boolean result = logService.createLog(log);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Log created successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to create log", null));
        }
    }

    @GetMapping
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLogById(@PathVariable int id) {
        boolean result = logService.deleteLogById(id);
        if (result) {
            return ResponseEntity.ok(new ApiResponse(200, "Log deleted successfully", null));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(400, "Failed to delete log", null));
        }
    }
}
