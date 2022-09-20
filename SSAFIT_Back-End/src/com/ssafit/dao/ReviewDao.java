package com.ssafit.dao;

import java.util.List;

import com.ssafit.dto.Review;

public interface ReviewDao {

    List<Review> selectByvideoId(String videoId);

    void regist(Review review);

    Review selectOne(int reviewId);

    void remove(int reviewId);

    void insert(Review review);

}
//목록 등록 수정 상세 삭제