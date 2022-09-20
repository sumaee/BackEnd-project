<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<<style>
#logo img {
  position: relative;
  width: 100px;
  height: 50px;
}

.search {
  position: relative;
}

.srch {
  position: absolute;
  background: url("img/ico_t_srch.png");
  width: 20px;
  height: 21px;
  border: 0;
  top: 10px;
  right: 20px;
}
</style>


<header>
	<div class="ct what">
		<div class="top">
			<div class="ct inner-top">
				<ul class="ct">
					<li><a href="VideoServlet?act=LikeList">찜 목록</a></li>
					<li>|</li>
					<li><a href="follow.jsp">팔로우 목록</a></li>
				</ul>
				<ul class="ct">
				<c:if test="${empty loginUser }">
					<li class="login"><a href="login.jsp">로그인</a></li>
					<li class="signup"><a href="signup.jsp">회원가입</a></li>
					</c:if>
					<c:if test="${not empty loginUser }">
					<li class="logout"><a href="UserServlet?act=doLogout">로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="ct main-top">
		<div class="main">
			<div id="logo">
				<a href="VideoServlet?act=Main"><img src="img/logo.png" alt=""></a>
			</div>
			<form action="VideoServlet" method="post">
			<div class="search">
				<input type="text" class="searchtext" name="videoTitle"
					placeholder="요즘 핫한 부위별 운동법은?">
					<input type="hidden" name="act" value="findVideo">
				<button class="srch"></button>
			</div>
			</form>
			<div id="ad-banner">
				<a href=""><img src="" alt=""></a>
			</div>
		</div>
	</div>
</header>