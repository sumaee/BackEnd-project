package com.ssafit.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafit.dto.Review;

public class ReviewDaoImpl implements ReviewDao {
	List<Review> reviewList = new ArrayList<>();
	private int reviewSeq = 1;
	private static ReviewDao instance = new ReviewDaoImpl();

	private ReviewDaoImpl() {
	}

	public static ReviewDao getInstance() {
		return instance;
	}

	@Override
	public void regist(Review review) {
		review.setReviewId(reviewSeq++);
		reviewList.add(review);
	}

	@Override
	public Review selectOne(int reviewId) {
		for (Review r : reviewList) {
			if (r.getReviewId() == reviewId)
				return r;
		}
		return null;
	}

	@Override
	public void remove(int reviewId) {
		reviewList.remove(selectOne(reviewId));
	}

	@Override
	public List<Review> selectByvideoId(String videoId) {
		List<Review> tmp = new ArrayList<>();
		for (Review r : reviewList) {
			if (r.getVideoId().equals(videoId))
				tmp.add(r);
		}
		return tmp;
	}

	@Override
	public void insert(Review review) {
		review.setReviewId(reviewSeq++);
		reviewList.add(review);
	}
}