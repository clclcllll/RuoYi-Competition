// Submission.java
package com.ruoyi.system.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Submission {
    private int submissionId;
    private String submissionName;
    private String category;
    private String school;
    private String team;
    private String materialPath;
    private Timestamp submissionDate;
    private int userId;
    private int competitionId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
