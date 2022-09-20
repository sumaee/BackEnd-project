<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="main.css">
<title>SSAFIT</title>
</head>

<body>
<c:if test="${!(empty sessionScope.msg) }">
        <script>
            alert("${sessionScope.msg}")
        </script>
        <c:set var="msg" value="" scope="session" />
    </c:if>
	<%@ include file="include/header.jsp"%>
	<main>
	<div class="ct what">
		<span class="arrow-right" id="Lbtn"></span>
		<!--오른쪽화살표-->
		<div class="pic">
			<img src="img/pic1.jpg" id="img">
			<!-- 사진-->
		</div>
		<span class="arrow-left" id="Rbtn"></span>
		<!-- 왼쪽화살표-->
	</div>
	<div class="ct what">
		<div class="d">
			<div class="dd">
				<h2>조회수 TOP3 영상</h2>
				<hr>
			</div>
			<div class="dda">
				

				<c:forEach var="video" items="${videoListSortByViewCnt }" begin="0"
					end="2">
					<div class="da">
						<div>
							<a
								href="VideoServlet?act=VideoDetail&videoId=${video.youtubeId }"><img class="da-img"
								src="https://img.youtube.com/vi/${video.youtubeId }/mqdefault.jpg"></img></a>
						</div>
						<div>${video.title}</div>
						<div class="ddda">
							<button>${video.fitPartName }</button>
							<div>${video.channelName }</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<div class="ct what">
		<div class="d">
			<div class="dd">
				<h2>부위별 추천 영상</h2>
				<form action="VideoServlet" method="get"><input type="hidden" name="act" value="VideoPart"><button class="part" name="part" value="전신" id="full">전신</button></form>
				<form action="VideoServlet" method="get"><input type="hidden" name="act" value="VideoPart"><button class="part" name="part" value="상체" id="upper">상체</button></form>
				<form action="VideoServlet" method="get"><input type="hidden" name="act" value="VideoPart"><button class="part" name="part" value="하체" id="lower">하체</button></form>
				<form action="VideoServlet" method="get"><input type="hidden" name="act" value="VideoPart"><button class="part" name="part" value="복부" id="abdominal">복부</button></form>
			</div>
			<hr>
			<div class="dda" id="part">

				<c:forEach var="video" items="${partList }">
					<div class="da">
						<div>
							<a
								href="VideoServlet?act=VideoDetail&videoId=${video.youtubeId }">
								<img
								src="https://img.youtube.com/vi/${video.youtubeId }/mqdefault.jpg"></img>
							</a>
						</div>
						<div>${video.title}</div>
						<div class="ddda">
							<button>${video.fitPartName }</button>
							<div>${video.channelName }</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	</main>
	<%@ include file="include/footer.jsp"%>
	<script>
	var main_img_num = 1;
	let static_value = (function static_func(value) {
		  let i = value;
		  return function () {
		    return ++i;
		  }
		})(0);
		var Rbtn = document.querySelector("#Rbtn");
		Rbtn.addEventListener("click", doActionRbtn);

		function doActionRbtn() {
		  let main_img_num = static_value();
		  var ele = document.querySelector("#img");
		  if (main_img_num % 4 === 0) {
		    ele.setAttribute("src", "img/pic1.jpg");
		  } else if (main_img_num % 4 === 1) {
		    ele.setAttribute("src", "img/pic2.png");
		  } else if (main_img_num % 4 === 2) {
		    ele.setAttribute("src", "img/pic3.jpg");
		  } else if (main_img_num % 4 === 3) {
		    ele.setAttribute("src", "img/pic4.jpg");
		  }

		}

		// 왼쪽 버튼
		var Lbtn = document.querySelector("#Lbtn");
		Lbtn.addEventListener("click", doActionLbtn);
		function doActionLbtn() {
		  console.log(1);
		  let main_img_num = static_value();
		  var ele = document.querySelector("#img");
		  if (main_img_num % 4 === 0) {
		    ele.setAttribute("src", "img/pic1.jpg");
		  } else if (main_img_num % 4 === 1) {
		    ele.setAttribute("src", "img/pic2.png");
		  } else if (main_img_num % 4 === 2) {
		    ele.setAttribute("src", "img/pic3.jpg");
		  } else if (main_img_num % 4 === 3) {
		    ele.setAttribute("src", "img/pic4.jpg");
		  }
		}
		</script>
</body>

</html>