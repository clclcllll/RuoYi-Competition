package com.ruoyi.system.service;

import com.ruoyi.system.domain.Competition;
import com.ruoyi.system.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;

    public List<Competition> getAllCompetitions() {
        return competitionMapper.selectAllCompetitions();
    }

    public boolean createCompetition(Competition competition) {
        return competitionMapper.insertCompetition(competition) > 0;
    }

    public boolean updateCompetition(int id, Competition competition) {
        return competitionMapper.updateCompetition(competition) > 0;
    }

    public boolean deleteCompetitionById(int competitionId) {
        return competitionMapper.deleteCompetitionById(competitionId) > 0;
    }

    public int getTotalCompetitions() {
        return 0;
    }

}
