// Competition.java
package com.ruoyi.system.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Competition {
    private Integer competitionId;
    private String competitionName;
    private String description;
    private Date competitionDate;
}
