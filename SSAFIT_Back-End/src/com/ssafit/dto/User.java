package com.ssafit.dto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String password;
    private String userName;
    private String nickName;
    private String email;
    private List<String> following;
    private List<String> follower;
    private List<Video> likeList;

    public User() {
    }

    public List<Video> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Video> likeList) {
		this.likeList = likeList;
	}

	public User(String id, String password, String userName, String nickName, String email) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        following = new ArrayList<>();
        follower = new ArrayList<>();
        likeList = new ArrayList<>();
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

    public List<String> getFollower() {
        return follower;
    }

    public void setFollower(List<String> follower) {
        this.follower = follower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", userName=" + userName + ", nickName=" + nickName
				+ ", email=" + email + ", following=" + following + ", follower=" + follower + ", likeList=" + likeList
				+ "]";
	}

}