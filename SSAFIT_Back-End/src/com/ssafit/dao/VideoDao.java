package com.ssafit.dao;

import java.util.List;

import com.ssafit.dto.Video;

public interface VideoDao {

	List<Video> selectAll();

	Video selectOne(String videoId);

	void updateViewCnt(String videoId);

	List<Video> searchByTitle(String videoTitle);
	
}
// 목록, 찜, 조회수, 상세