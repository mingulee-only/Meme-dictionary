<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
.inner {
	position: absolute;
	width: 700px;
	height: 600px;
	top: 50%;
	left: 50%;
	margin-top: -250px;
	margin-left: -350px;
	background-color: lightgray;
}

.body {
	height: 90%;
}
.content {
	height : 75%;
	width : 100%;
	float : left;
}
.pi {
	height : 10%;
}
.footer {
	height : 10%;
}

.body ul {
	list-style-type: none;
	padding-left: 130px;
}

.body li {
	color: white;
	float: left;
	background-color: #4A4646;
	padding-right: 10px;
	text-align: center;
}

.body li a {
	color: white;
	display: block;
	background-color: darkgray;
	text-decoration: none;
	text-align: center;
}

.body li a.current {
	color: white;
}

#no {
	width: 35px;
}

#title {
	width: 250px;
}

#writer {
	width: 100px;
}

#date {
	width: 100px;
}

#update {
	width: 50px;
}

#views {
	width: 50px;
}


.header {
	color: white;
	background-color: #4A4646;
	height: 30px;
}

.sub {
	font-size: smaller;
}
.inner-header {
	height: 15%;
}
</style>
</head>
<body>


	<div class="inner" align="center">
		<div class="body" align="center">
			<div class="inner-header">
				<br>
				<br>
				<ul>
					<li><a href="/admin/manageMember.me">회원 관리</a></li>
					<li>유행어 사전 관리</li>
					<li><a href="/admin/manageBoard.me">추진/자유게시판 관리</a></li>
					<li><a href="/admin/manageQuiz.me">퀴즈 관리</a></li>
				</ul>
				<br>
				<ul class="sub">
					<li>전체 유행어 목록</li>
					<li><a href="/admin/manageMemeRequest.me">사전 요청 목록</a></li>
				</ul>
				<br>
			</div>
			<div class="content">
			<br>
				<table align="center" border="1">
					<tr class="header">
						<td id="no">번호</td>
						<td id="title">유행어</td>
						<td id="writer">출처</td>
						<td id="date" colspan="2">등재일</td>
					</tr>
					<c:forEach items="${allMemeList }" var="allMemeList">
						<tr>
							<td>${allMemeList.memeNo }</td>
							<c:url var="mDetail" value="/meme/detail">
								<c:param name="memeName" value="${allMemeList.memeName }"></c:param>
							</c:url>
							<td><a href="${mDetail }">${allMemeList.memeName }</a></td>
							<td>${allMemeList.memberNickname }</td>
							<td>${allMemeList.memeDate }</td>
							<td>삭제</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="text-align:center" class="pi">
				<c:if test="${pi.startNavi gt 1 }">
					<button style="height:25px; width:55px">이전</button>
				</c:if>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/admin/manageMeme.me">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }">${p }</a>&nbsp;
				</c:forEach>
				<c:if test="${pi.endNavi lt maxPage }">
					<button style="height:25px; width:55px">다음</button>
				</c:if>
			</div>
		</div>
		
		<div class="footer">
			<button type="button" onclick="location.href='/'">홈으로</button>
			<button type="button" onclick="location.href='/member/logout.me'">로그아웃</button>		
		</div>
	</div>
</body>
</html>