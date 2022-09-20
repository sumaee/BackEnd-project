package com.ssafit.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafit.dto.User;
import com.ssafit.dto.Video;

public class UserDaoImpl implements UserDao {
	VideoDao videodao = VideoDaoImpl.getInstance();
	List<User> userList = new ArrayList<>();
	List<User> followList = new ArrayList<>();
	List<Video> likeList = new ArrayList<>();
	
	User loginUser = null;
	private static UserDaoImpl instance = new UserDaoImpl();

	private UserDaoImpl() {
	}

	public static UserDaoImpl getInstance() {
		return instance;
	}

	@Override
	public boolean regist(User user) {
		for (User u : userList) {
			if (user.getId().equals(u.getId())) {
				return false;
			}
		}
		userList.add(user);
		return true;
	}

	@Override
    public User login(String id, String password) {

        for (User u : userList) {
            if (u.getId().equals(id) && u.getPassword().equals(password)) {
                loginUser = u;
                likeList = loginUser.getLikeList();
                return u;
            }
        }

        return null;
    }

	@Override
	public void follow(User user) {
		if (user != loginUser) {
			if (!loginUser.getFollowing().contains(user.getId())) {
				loginUser.getFollowing().add(user.getId());
				user.getFollower().add(loginUser.getId());
			}
		}
	}

	@Override
	public User selectOne(String id) {

		for (User u : userList) {
			if (u.getId().equals(id)) {
				return u;
			}
		}

		return null;
	}

	@Override
	public void removeOne(String id) {

		for (User u : userList) {
			if (u.getId().equals(id)) {
				userList.remove(u);
			}
		}
	}

	@Override
	public List<String> followerList(String id) {

		for (User u : userList) {
			if (u.getId().equals(id)) {
				return u.getFollower();
			}
		}

		return null;
	}

	@Override
	public List<String> followingList(String id) {

		for (User u : userList) {
			if (u.getId().equals(id)) {
				return u.getFollowing();
			}
		}

		return null;
	}

	@Override
	public User getLoginUser() {

		return loginUser;
	}
	
	@Override
	public boolean like(String videoId) {
		for (Video v : likeList) {
			if (v.getYoutubeId().equals(videoId)) {
				return false;
			}
		}
		likeList.add(videodao.selectOne(videoId));
		return true;
	}
	
	@Override
	public List<Video> list() {

		return likeList;
	}
	
	@Override
	public void removeLike(String videoId) {
		List<Video> removeList = new ArrayList<>();
		for (Video v : likeList) {
			if (v.getYoutubeId().equals(videoId)) {
				removeList.add(v);
				break;
			}
		}
		likeList.removeAll(removeList);
	}
}