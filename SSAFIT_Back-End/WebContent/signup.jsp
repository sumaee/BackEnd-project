<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="signup.css">
<title>SSAFIT 회원가입</title>
</head>

<body>
	<c:if test="${!(empty sessionScope.msg) }">
		<script>
			alert("${sessionScope.msg}")
		</script>
		<c:set var="msg" value="" scope="session" />
	</c:if>
	<form action="UserServlet" method="post">
		<input type="hidden" name="act" value="doUserRegist">
		<fieldset>
			<br> <br>
			<h2>회원가입</h2>
			<div class="textForm">
				<input type="text" class="id" name="id" placeholder="아이디">
			</div>
			<div class="textForm">
				<input type="password" class="pw" name="password" placeholder="비밀번호">
			</div>
			<div class="textForm">
				<input type="text" class="id" name="userName" placeholder="이름">
			</div>
			<div class="textForm">
				<input type="text" class="id" name="nickName" placeholder="닉네임">
			</div>
			<div class="textForm">
				<input type="email" class="id" name="email" placeholder="이메일">
			</div>
			<input type="submit" class="btn" value="등록"> <input
				type="reset" class="btn" value="초기화" style="margin-bottom: 15px;"><br> 
			<a href="VideoServlet?act=Main" style="text-decoration: none;">홈으로</a>
		</fieldset>
	</form>
	<script src=" ../js/signup.js"></script>
</body>

</html>