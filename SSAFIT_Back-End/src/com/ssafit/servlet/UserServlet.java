package com.ssafit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafit.dao.UserDao;
import com.ssafit.dao.UserDaoImpl;
import com.ssafit.dao.VideoDao;
import com.ssafit.dao.VideoDaoImpl;
import com.ssafit.dto.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userdao = UserDaoImpl.getInstance();
	private VideoDao videodao = VideoDaoImpl.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		session.setAttribute("userdao", userdao);
		session.setAttribute("videodao", videodao);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String act = req.getParameter("act");
		switch (act) {
		case "doUserRegist":
			doUserRegist(req, resp);
			break;

		case "doLogin":
			doLogin(req, resp);
			break;

		case "doLogout":
			doLogout(req, resp);
			break;

		case "doFollow":
			doFollow(req, resp);
			break;

		case "doFollowList":
			doFollowList(req, resp);
			break;

		case "doFollowingRemove":
			doFollowingRemove(req, resp);
			break;

		case "doFollowerRemove":
			doFollowerRemove(req, resp);
			break;

		default:
			break;
		}
	}

	private void doFollowerRemove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		List<String> follower = loginUser.getFollower();
		follower.remove(id);
		req.setAttribute("follower", follower);
		List<String> following = userdao.followingList(id);
		following.remove(loginUser.getId());
		req.setAttribute("following", following);

		req.getRequestDispatcher("/follow.jsp").forward(req, resp);
	}

	private void doFollowingRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		List<String> follower = userdao.followerList(id);
		follower.remove(loginUser.getId());
		req.setAttribute("follower", follower);
		List<String> following = loginUser.getFollowing();
		following.remove(id);
		req.setAttribute("following", following);

		req.getRequestDispatcher("/follow.jsp").forward(req, resp);
	}

	private void doFollowList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String id = session.getId();

		List<String> follower = userdao.followerList(id);
		req.setAttribute("follower", follower);

		List<String> following = userdao.followerList(id);
		req.setAttribute("following", following);

		req.getRequestDispatcher("/follow.jsp").forward(req, resp);
	}

	private void doFollow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			String videoId = req.getParameter("videoId");
			String id = req.getParameter("id");
			userdao.follow(userdao.selectOne(id));
			session.setAttribute("loginUser", userdao.getLoginUser());
			resp.sendRedirect("VideoServlet?act=VideoDetail&videoId=" + videoId);
		} else {
			String msg = "로그인이 필요한 작업입니다.";
			session.setAttribute("msg", msg);

			resp.sendRedirect("login.jsp");
		}

	}

	private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		session.invalidate();

		resp.sendRedirect("index.jsp");
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		User user = null;
		String msg = "";
		HttpSession session = req.getSession();

		if (id != "" && password != "") {
			user = userdao.login(id, password);
			if (user != null) {
				msg = "로그인 성공!";
				session.setAttribute("msg", msg);
				session.setAttribute("loginUser", user);
				resp.sendRedirect("VideoServlet?act=Main");
			} else {
				msg = "아이디가 존재하지 않거나 비밀번호가 틀립니다.";
				session.setAttribute("msg", msg);
				resp.sendRedirect("login.jsp");
			}
		} else {
			msg = "아이디와 비밀번호를 입력해주세요";
			session.setAttribute("msg", msg);
			resp.sendRedirect("login.jsp");
		}

	}

	private void doUserRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String userName = req.getParameter("userName");
		String nickName = req.getParameter("nickName");
		String email = req.getParameter("email");

		System.out.println(id);
		User user = null;
		String msg = null;
		HttpSession session = req.getSession();

		if (id != "" && password != "" && userName != "" && nickName != "" && email != "") {
			user = new User(id, password, userName, nickName, email);
			if (userdao.regist(user)) {
				msg = "회원가입이 완료되었습니다.";
				session.setAttribute("msg", msg);
				resp.sendRedirect("login.jsp");
			} else {
				msg = "이미 존재하는 아이디 입니다.";
				session.setAttribute("msg", msg);
				resp.sendRedirect("signup.jsp");
			}
		} else {
			msg = "빈칸을 모두 작성해주세요";
			session.setAttribute("msg", msg);
			resp.sendRedirect("signup.jsp");
		}

	}

}