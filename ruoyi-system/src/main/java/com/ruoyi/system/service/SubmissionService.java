package com.ruoyi.system.service;

import com.ruoyi.system.domain.Submission;
import com.ruoyi.system.mapper.SubmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionMapper submissionMapper;

    public List<Submission> getAllSubmissions() {
        return submissionMapper.selectAllSubmissions();
    }

    public List<Submission> getSubmissionsByUserId(int userId) {
        return submissionMapper.selectSubmissionsByUserId(userId);
    }

    public boolean createSubmission(Submission submission) {
        return submissionMapper.insertSubmission(submission) > 0;
    }

    public int getTotalSubmissions() {
        return 0;
    }

    public Submission getSubmissionById(int submissionId) {
        return submissionMapper.selectSubmissionById(submissionId);
    }

    public boolean updateSubmission(Submission submission) {
        return submissionMapper.updateSubmission(submission) > 0;
    }

    public boolean deleteSubmissionById(int id) {
        return submissionMapper.deleteSubmissionById(id) > 0;
    }
}
