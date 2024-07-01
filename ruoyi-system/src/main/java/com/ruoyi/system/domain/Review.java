// Review.java
package com.ruoyi.system.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Review {
    private int reviewId;
    private int submissionId;
    private int expertId;
    private int score;
    private String comment;
    private Timestamp reviewDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
