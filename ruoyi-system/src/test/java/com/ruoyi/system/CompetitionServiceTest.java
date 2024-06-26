package com.ruoyi.system;

import com.ruoyi.system.domain.Competition;
import com.ruoyi.system.service.CompetitionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompetitionServiceTest {

    @Autowired
    private CompetitionService competitionService;

    @Test
    public void testCreateCompetition() {
        Competition competition = new Competition();
        competition.setCompetitionName("Test Competition");
        competition.setDescription("Description for Test Competition");
        competition.setCompetitionDate(new Date());

        int result = competitionService.createCompetition(competition);
        assertEquals(1, result);
    }

    @Test
    public void testGetAllCompetitions() {
        List<Competition> competitions = competitionService.getAllCompetitions();
        assertNotNull(competitions);
        assertTrue(competitions.size() > 0);
    }
}
