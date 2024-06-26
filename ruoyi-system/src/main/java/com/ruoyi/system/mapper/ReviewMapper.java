package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Review;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    int insertReview(Review review);
    List<Review> selectAllReviews();
    List<Review> selectReviewsBySubmissionId(Integer submissionId);
}
