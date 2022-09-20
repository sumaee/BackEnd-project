package com.ssafit.dao;

import java.util.List;

import com.ssafit.dto.User;
import com.ssafit.dto.Video;

public interface UserDao {

	boolean regist(User user);

	void follow(User user);

	User selectOne(String id);

	void removeOne(String id);

	User login(String id, String password);

	List<String> followerList(String id);

	List<String> followingList(String id);

	User getLoginUser();

	boolean like(String videoId);

	List<Video> list();

	void removeLike(String videoId);

}
//등록 로그인 로그아웃 목록 팔로잉 