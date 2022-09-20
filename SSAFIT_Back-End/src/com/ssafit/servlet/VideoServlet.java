package com.ssafit.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafit.dao.ReviewDao;
import com.ssafit.dao.ReviewDaoImpl;
import com.ssafit.dao.UserDao;
import com.ssafit.dao.UserDaoImpl;
import com.ssafit.dao.VideoDao;
import com.ssafit.dao.VideoDaoImpl;
import com.ssafit.dto.Review;
import com.ssafit.dto.User;
import com.ssafit.dto.Video;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao = UserDaoImpl.getInstance();
	private VideoDao videodao = VideoDaoImpl.getInstance();
	private ReviewDao reviewdao = ReviewDaoImpl.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		session.setAttribute("userdao", userdao);
		session.setAttribute("videodao", videodao);

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String act = req.getParameter("act");
		switch (act) {
		case "VideoList":
			doVideoList(req, resp);
			break;
		case "VideoDetail":
			doVideoDetail(req, resp);
			break;
		case "findVideo":
			dofindVideo(req, resp);
			break;
		case "ReviewRegist":
			doReviewRegist(req, resp);
			break;
		case "ReviewRemove":
			doReviewRemove(req, resp);
			break;
		case "ReviewUpdate":
			doReviewUpdate(req, resp);
			break;
		case "Like":
			doLike(req, resp);
			break;
		case "LikeRemove":
			doLikeRemove(req, resp);
			break;
		case "VideoPart":
			doVideoPart(req, resp);
			break;
		case "Main":
			doMain(req, resp);
			break;
		case "LikeList":
			doLikeList(req, resp);
			break;
		default:
			break;
		}
	}

	private void dofindVideo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session= req.getSession();
		
		String videotitle=req.getParameter("videoTitle");
		
		if(videotitle.equals("")) {
			String msg="검색어를 입력해주세요.";
			session.setAttribute("msg", msg);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			
			List<Video> video = videodao.searchByTitle(videotitle);
			req.setAttribute("searchList", video);
			req.getRequestDispatcher("/searchList.jsp").forward(req, resp);
			
		}
		
	}

	private void doLikeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("likeList", userdao.list());
		req.getRequestDispatcher("/like.jsp").forward(req, resp);
	}

	private void doMain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> videoList = videodao.selectAll();
		Collections.sort(videoList, new Comparator<Video>() {
			@Override
			public int compare(Video o1, Video o2) {
				return o2.getViewCnt() - o1.getViewCnt();
			}
		});
		req.setAttribute("videoListSortByViewCnt", videoList);
		List<Video> partList = new ArrayList<>();
		for (Video v : videoList) {
			if (v.getFitPartName().equals("전신"))
				partList.add(v);
		}
		req.setAttribute("partList", partList);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	private void doVideoPart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> videoList = videodao.selectAll();
		Collections.sort(videoList, new Comparator<Video>() {
			@Override
			public int compare(Video o1, Video o2) {
				return o2.getViewCnt() - o1.getViewCnt();
			}
		});
		req.setAttribute("videoListSortByViewCnt", videoList);
		String part = req.getParameter("part");
		List<Video> partList = new ArrayList<>();
		for (Video v : videoList) {
			if (v.getFitPartName().equals(part))
				partList.add(v);
		}
		req.setAttribute("partList", partList);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	private void doLikeRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String youtubeId = req.getParameter("youtubeId");
		userdao.removeLike(youtubeId);

		resp.sendRedirect("VideoServlet?act=LikeList");
	}

	private void doLike(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		String youtubeId = req.getParameter("videoId");

		String msg = "";

		if (loginUser != null) {
			if (userdao.like(youtubeId)) {
				msg = "찜하기 완료!!";
			} else {
				msg = "이미 찜한 영상입니다!";
			}

			session.setAttribute("msg", msg);
			req.setAttribute("video", videodao.selectOne(youtubeId));

			List<Review> reviewList = reviewdao.selectByvideoId(youtubeId);
			Collections.sort(reviewList, new Comparator<Review>() {
				@Override
				public int compare(Review o1, Review o2) {
					return o2.getReviewId() - o1.getReviewId();
				}
			});
			req.setAttribute("reviewList", reviewList);

			req.getRequestDispatcher("/videodetail.jsp").forward(req, resp);
		} else {
			msg = "로그인이 필요한 작업입니다.";
			session.setAttribute("msg", msg);

			resp.sendRedirect("login.jsp");
		}

	}

	private void doReviewUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			String videoId = req.getParameter("videoId");
			int reviewId = Integer.parseInt(req.getParameter("reviewId"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			Review review = reviewdao.selectOne(reviewId);

			review.setContent(content);
			review.setTitle(title);

			resp.sendRedirect("VideoServlet?act=VideoDetail&videoId=" + videoId);
		} else {
			String msg = "로그인이 필요한 작업입니다.";
			session.setAttribute("msg", msg);

			resp.sendRedirect("login.jsp");
		}

	}

	private void doReviewRemove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			String videoId = req.getParameter("videoId");
			int reviewId = Integer.parseInt(req.getParameter("reviewId"));

			reviewdao.remove(reviewId);
			resp.sendRedirect("VideoServlet?act=VideoDetail&videoId=" + videoId);
		} else {
			String msg = "로그인이 필요한 작업입니다.";
			session.setAttribute("msg", msg);

			resp.sendRedirect("login.jsp");
		}

	}

	private void doReviewRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			String videoId = req.getParameter("videoId");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String userId = ((User) session.getAttribute("loginUser")).getId();
			Review review = new Review(videoId, title, content, userId,
					DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()));

			reviewdao.regist(review);

			resp.sendRedirect("VideoServlet?act=VideoDetail&videoId=" + videoId);
		} else {
			String msg = "로그인이 필요한 작업입니다.";
			session.setAttribute("msg", msg);

			resp.sendRedirect("login.jsp");
		}

	}


	private void doVideoDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoId");

		Video video = videodao.selectOne(id);
		req.setAttribute("video", video);
		videodao.updateViewCnt(id);
		
		List<Review> reviewList = reviewdao.selectByvideoId(id);
		Collections.sort(reviewList, new Comparator<Review>() {
			@Override
			public int compare(Review o1, Review o2) {
				return o2.getReviewId() - o1.getReviewId();
			}
		});
		req.setAttribute("reviewList", reviewList);
		req.getRequestDispatcher("videodetail.jsp").forward(req, resp);
	}

	private void doVideoList(HttpServletRequest req, HttpServletResponse resp) {
		List<Video> videoList = videodao.selectAll();
		req.setAttribute("videoList", videoList);
	}
}