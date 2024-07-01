package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Competition;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CompetitionMapper {
    List<Competition> selectAllCompetitions();
    Competition selectCompetitionById(int competitionId);
    int insertCompetition(Competition competition);
    int updateCompetition(Competition competition);
    int deleteCompetitionById(int competitionId);
}
