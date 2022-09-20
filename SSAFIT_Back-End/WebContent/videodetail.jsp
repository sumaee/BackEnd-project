<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="videodetail.css">
<title>비디오 상세정보</title>
</head>
<body>
	<%@include file="include/header.jsp"%>
	<c:if test="${!(empty sessionScope.msg) }">
		<script>
			alert("${sessionScope.msg}")
		</script>
		<c:set var="msg" value="" scope="session" />
	</c:if>


	<div class="ct what review">
		<div class="ct what">
			<div class="pic">
				<h2 class="ct what">운동 영상 리뷰</h2>
				<hr>
				<div class="ct what">
					<div>
						<iframe id="video"
							src="https://www.youtube.com/embed/${video.youtubeId }"></iframe>
					</div>
				</div>
				<hr>
				
				<div style="margin-left:64px; font-size:16px;">조회수 : ${video.viewCnt }</div>
				
				<div class="ct">
					<button id="open-regist">리뷰 등록</button>
					<form action="VideoServlet" method="post"
						style="display: flex; flex-direction: column; justify-content: flex-end;">
						<input type="hidden" name="videoId" value="${video.youtubeId }">
						<input type="hidden" name="act" value="Like">
						<button id="jjim">찜하기</button>
					</form>
				</div>
				<!-- modal-->
				<div class="modal hidden" id="modal-regist">
					<div class="bg"></div>
					<div class="modalBox">
						<h2>리뷰 작성하기</h2>
						<form id="registmodal" action="VideoServlet" method="post"
							style="display: flex; align-items: center; flex-direction: column;">
							<input type="hidden" name="videoId" value="${video.youtubeId }">
							<input type="hidden" name="act" value="ReviewRegist"> <input
								class="title" id="regist-title" name="title" type="text"
								placeholder="제목"> <input class="context"
								id="regist-context" name="content" type="text" placeholder="내용">
							<div class="modal-ct">
								<button id="registReview" class="btn"
									style="position: absolute; top: 294px; right: 402px;">등록</button>
							</div>
						</form>
						<div id="noregist">
							<button id="close-regist"
								style="position: absolute; top: 294px; right: 243px;">취소</button>
						</div>
					</div>
				</div>
				<!-- modal -->
				<div class="tablediv">
					<table class="table">
						<tr>
							<th class="td-1">번호</th>
							<td class="td-2">제목</td>
							<td class="td-3">작성자</td>
							<td class="td-5">작성 시간</td>
						</tr>
						<!--  -->
						<c:forEach var="review" items="${reviewList }" varStatus="status">
							<tr id="review${status.index}">
								<th>${status.count}</th>
								<td class="reviewli">${review.title}</td>
								<td>${review.userId}</td>
								<td>${review.regDate}</td>
							</tr>
							<tr class="hidden" id="review${status.index}context">
								<td colspan="4">
									<div class="realcontext">
										<div>${review.content}</div>
										<div style="display: flex;">
											<c:if test="${loginUser.id.equals(review.userId)}">
												<button class="edit" id="edit${status.index}"
													style="width: 60px; margin: 0;">수정</button>
											</c:if>
											<form action="VideoServlet" method="post">
												<input type="hidden" name="videoId"
													value="${video.youtubeId }"> <input type="hidden"
													name="reviewId" value="${review.reviewId }">
												<c:if test="${loginUser.id.equals(review.userId)}">
													<button class="delete" id="delete${status.index}"
														name="act" value="ReviewRemove"
														style="width: 60px; margin: 0;">삭제</button>
												</c:if>
											</form>
											<form action="UserServlet" method="post">
												<input type="hidden" name="videoId"
													value="${video.youtubeId }"> <input type="hidden"
													name="act" value="doFollow"> <input type="hidden"
													name="id" value="${review.userId}">
												<c:if test="${!loginUser.id.equals(review.userId)&& loginUser!=null}">
													<button class="follow" id="follow${status.index}">팔로우</button>
												</c:if>
											</form>
										</div>
										<div class="modal hidden" id="modal-edit${status.index}">
											<div class="bg"></div>
											<div class="modalBox">
												<h2>리뷰 수정하기</h2>
												<form id="updatemodal" action="VideoServlet" method="post"
													style="display: flex; align-items: center; flex-direction: column;">
													<input type="hidden" name="videoId"
														value="${video.youtubeId }"> <input type="hidden"
														name="reviewId" value="${review.reviewId }"> <input
														type="hidden" name="act" value="ReviewUpdate"> <input
														class="title" id="edittitle${status.index}" name="title"
														type="text" value="${review.title}"> <input
														class="context" id="editcontext${status.index}"
														name="content" type="text" value="${review.content}">
													<div class="modal-ct">

														<button class="btn confirm" id="editReview${status.index}"
															style="position: absolute; top: 294px; right: 402px;">수정</button>
													</div>
												</form>
												<button class="btn cancel" id="close-edit${status.index}"
													style="position: absolute; top: 294px; right: 243px;">취소</button>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
						<!--  -->
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="include/footer.jsp"%>
	<script src="videodetail.js">
		
	</script>
</body>
</html>