// Log.java
package com.ruoyi.system.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Log {
    private int logId;
    private int userId;
    private String operation;
    private Timestamp operationDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
