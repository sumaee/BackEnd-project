<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">

<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
<c:if test="${!(empty sessionScope.msg) }">
        <script>
            alert("${sessionScope.msg}")
        </script>
        <c:set var="msg" value="" scope="session" />
    </c:if>
	<form action="UserServlet" method="post">
	<input type="hidden" name="act" value="doLogin">
		<fieldset>
			<br>
			<br>
			<h2>로그인</h2>
			<div class="textForm">
				<input type="text" name="id" class="id" placeholder="아이디">
			</div>
			<div class="textForm">
				<input type="password" name="password" class="pw" placeholder="비밀번호">
			</div>
			<input type="submit" id="login" class="btn btn-outline-secondary" value="로그인" style="margin-bottom: 15px;"/><br>
			<a href="VideoServlet?act=Main" style="text-decoration:none;">홈으로</a>
			<a href="signup.jsp" style="text-decoration:none;">회원가입</a>
		</fieldset>
	</form>




	<h2></h2>
</body>
</html>