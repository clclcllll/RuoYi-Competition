package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Submission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubmissionMapper {
    int insertSubmission(Submission submission);
    List<Submission> selectAllSubmissions();
    List<Submission> selectSubmissionsByUserId(Integer userId);
}
