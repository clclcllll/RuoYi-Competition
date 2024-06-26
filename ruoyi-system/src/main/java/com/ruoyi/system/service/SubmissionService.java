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

    public int createSubmission(Submission submission) {
        return submissionMapper.insertSubmission(submission);
    }

    public List<Submission> getAllSubmissions() {
        return submissionMapper.selectAllSubmissions();
    }

    public List<Submission> getSubmissionsByUserId(Integer userId) {
        return submissionMapper.selectSubmissionsByUserId(userId);
    }

    public int getTotalSubmissions() {
        return submissionMapper.selectAllSubmissions().size();
    }
}
