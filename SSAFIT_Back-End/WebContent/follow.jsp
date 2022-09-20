<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팔로우, 팔로잉 확인 화면</title>
<link rel="stylesheet" href="follow.css">
</head>
<body>
	<%@include file="include/header.jsp"%>
	<main>
	<div class="ct what">
		<div class="d">
			<div class="dd">
				<h2>팔로우 목록</h2>
				<hr>
			</div>
			<div class="dda">
				<!--팔로잉한 사람-->
				<div class="follow following">
					<h1>Following</h1>
					<hr>
					<c:forEach var="user" items="${loginUser.following }">
						<form action="UserServlet" method="post">
							<div class="person">
								<input type="hidden" name="act" value="doFollowingRemove">
								<input type="hidden" name="id" value="${user }">
								<img src="img/avata.png"><span>${user}</span>
								<button class="del-btn">삭제</button>
							</div>
						</form>
					</c:forEach>
				</div>
				<!--팔로워한 사람-->
				<div class="follow follower">
					<h1>Follower</h1>
					<hr>
					<c:forEach var="user" items="${loginUser.follower }">
					<form action="UserServlet" method="post">
						<div class="person">
							<input type="hidden" name="act" value="doFollowerRemove"> 
							<input type="hidden" name="id" value="${user }">
							<img
								src="img/avata.png"><span>${user}</span>
								<button class="del-btn">삭제</button>
						</div>
						</form>
					</c:forEach>
				</div>
				<!--팔로우 목록 들어갈 곳-->
			</div>
		</div>
	</div>
	</main>
	<%@include file="include/footer.jsp"%>
</body>
</html>