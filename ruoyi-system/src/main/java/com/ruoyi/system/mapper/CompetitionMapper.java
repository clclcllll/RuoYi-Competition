package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Competition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompetitionMapper {
    int insertCompetition(Competition competition);
    List<Competition> selectAllCompetitions();
}
