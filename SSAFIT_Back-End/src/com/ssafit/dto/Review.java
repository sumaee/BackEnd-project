package com.ssafit.dto;

public class Review {
    private int reviewId;
    private String videoId;
    private String title;
    private String content;
    private String userId;
    private String regDate;

    public Review() {
    }

    public Review(String videoId, String title, String content, String userId, String regDate) {
        this.videoId = videoId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.regDate = regDate;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", videoId=" + videoId + ", title=" + title + ", content=" + content
                + ", userId=" + userId + ", regDate=" + regDate + "]";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

}