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

    public int createCompetition(Competition competition) {
        return competitionMapper.insertCompetition(competition);
    }

    public List<Competition> getAllCompetitions() {
        return competitionMapper.selectAllCompetitions();
    }

    public int getTotalCompetitions() {
        return competitionMapper.selectAllCompetitions().size();
    }
}
