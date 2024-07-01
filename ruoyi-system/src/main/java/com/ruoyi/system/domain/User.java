package com.ruoyi.system.domain;

import lombok.Data;

import java.sql.Timestamp;
// User.java
@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    private String name;
    private String contactInfo;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

