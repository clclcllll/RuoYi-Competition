package com.ruoyi.system;

import com.ruoyi.system.domain.Submission;
import com.ruoyi.system.service.SubmissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SubmissionServiceTest {

    @Autowired
    private SubmissionService submissionService;

    @Test
    public void testCreateSubmission() {
        Submission submission = new Submission();
        submission.setSubmissionName("Test Submission");
        submission.setCategory("Test Category");
        submission.setSchool("Test School");
        submission.setTeam("Test Team");
        submission.setMaterialPath("Test Path");
        submission.setUserId(1);

        int result = submissionService.createSubmission(submission);
        assertEquals(1, result);
    }

    @Test
    public void testGetAllSubmissions() {
        List<Submission> submissions = submissionService.getAllSubmissions();
        assertNotNull(submissions);
        assertTrue(submissions.size() > 0);
    }
}
