package com.ssafit.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafit.dto.Video;

public class VideoDaoImpl implements VideoDao {
	List<Video> videoList = new ArrayList<>();
	List<Video> likeList = new ArrayList<>();
	private static VideoDao instance = new VideoDaoImpl();

	private VideoDaoImpl() {
		videoList.add(new Video("gMaB-fG4u4g", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "전신", "ThankyouBUBU", 1));
		videoList.add(new Video("swRNeYw1JkY", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "전신", "ThankyouBUBU", 2));
		videoList.add(new Video("54tTYO-vU2E", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "상체", "ThankyouBUBU", 3));
		videoList.add(new Video("QqqZH3j_vH0", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "ThankyouBUBU", 4));
		videoList.add(new Video("tzN6ypk6Sps", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "김강민", 5));
		videoList.add(new Video("u5OgcZdNbMo", "저는 하체 식주의자 입니다", "하체", "GYM종국", 6));
		videoList.add(new Video("PjGcOP-TQPE", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "ThankyouBUBU", 7));
		videoList.add(new Video("7TLk7pscICk", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "SomiFit", 8));
	}

	public static VideoDao getInstance() {
		return instance;
	}

	@Override
	public List<Video> selectAll() {

		return videoList;
	}

	@Override
	public Video selectOne(String videoId) {
		for (Video v : videoList) {
			if (v.getYoutubeId().equals(videoId)) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void updateViewCnt(String videoId) {
		Video v = selectOne(videoId);
		v.setViewCnt(v.getViewCnt() + 1);
	}

	@Override
	public List<Video> searchByTitle(String videoTitle) {
		List<Video> searchList =new ArrayList<>();
		for(Video v: videoList) {
			if(v.getTitle().contains(videoTitle)) {
				searchList.add(v);
			}
		}
		
		if(searchList.size()!=0) {
			return searchList;
		}
		
		return null;
	}

}