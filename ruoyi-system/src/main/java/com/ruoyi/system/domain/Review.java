// Review.java
package com.ruoyi.system.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private Integer reviewId;
    private Integer submissionId;
    private Integer expertId;
    private Integer score;
    private String comment;
    private Date reviewDate;
}
