<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="like.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="include/header.jsp"%>
	<main>
	<div class="ct what">
		<div class="d">
			<div class="dd">
				<h2>검색 결과</h2>
				<hr>
			</div>

			<c:if test="${empty searchList }">
				<h2>검색 결과가 없습니다.</h2>
			</c:if>
			<div class="dda">
					<!--찜 동영상 들어갈 곳-->
					<c:forEach var="video" items="${searchList }">

						<div class="da">
							<div>
								<a
									href="VideoServlet?act=VideoDetail&videoId=${video.youtubeId }"><img
									class="da-img"
									src="https://img.youtube.com/vi/${video.youtubeId }/mqdefault.jpg"></img></a>
							</div>
							<div>${video.title}</div>
							<div class="ddda">
								<a
									href="VideoServlet?act=LikeRemove&youtubeId=${video.youtubeId }">삭제</a>
								<div>${video.channelName }</div>
							</div>
						</div>

					</c:forEach>
		</div>
	</div>
	</div>
	</main>
	<%@include file="include/footer.jsp"%>
</body>
</html>