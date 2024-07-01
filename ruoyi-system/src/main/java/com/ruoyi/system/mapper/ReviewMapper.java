package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> selectAllReviews();
    List<Review> selectReviewsBySubmissionId(int submissionId);
    int insertReview(Review review);
    int updateReview(Review review);
    int deleteReviewById(int reviewId);
}
