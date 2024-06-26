package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Competition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompetitionMapper {
    Competition selectById(Integer id);
    int insertCompetition(Competition competition);
    int updateCompetition(Competition competition);
    int deleteCompetition(Integer id);
    List<Competition> selectAllCompetitions();
}
