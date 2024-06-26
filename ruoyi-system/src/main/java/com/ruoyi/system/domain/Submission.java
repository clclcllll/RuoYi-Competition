// Submission.java
package com.ruoyi.system.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Submission {
    private Integer submissionId;
    private String submissionName;
    private String category;
    private String school;
    private String team;
    private String materialPath;
    private Date submissionDate;
    private Integer userId;
}
