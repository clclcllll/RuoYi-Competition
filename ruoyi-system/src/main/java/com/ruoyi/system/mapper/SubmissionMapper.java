package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Submission;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SubmissionMapper {
    List<Submission> selectAllSubmissions();
    Submission selectSubmissionById(int submissionId);
    int insertSubmission(Submission submission);
    int updateSubmission(Submission submission);
    int deleteSubmissionById(int submissionId);

    List<Submission> selectSubmissionsByUserId(int userId);
}
