// Log.java
package com.ruoyi.system.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private Integer logId;
    private Integer userId;
    private String operation;
    private Date operationDate;
}
