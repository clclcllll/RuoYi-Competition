package com.ruoyi.system.domain;

import lombok.Data;

// User.java
@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String role;
    private String name;
    private String contactInfo;
}

