// Competition.java
package com.ruoyi.system.domain;


import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Competition {
    private int competitionId;
    private String competitionName;
    private String description;
    private java.sql.Date competitionDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
