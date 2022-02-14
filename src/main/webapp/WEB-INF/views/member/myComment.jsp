<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
.inner {
	position: absolute;
	width: 700px;
	height: 500px;
	top: 50%;
	left: 50%;
	margin-top: -250px;
	margin-left: -350px;
	background-color: lightgray;
}

.body {
	height: 90%;
}

.body ul {
	list-style-type : none;
	padding-left : 150px;
}
.body li {
	color : white;
	float : left;
	background-color : #4A4646;
	padding-right : 10px;
	text-align : center;
}
.body li a {
	color : white;
	display : block;
	background-color : darkgray;
	text-decoration : none;
	text-align : center;
}
.body li a.current {
		color : white;
}

#part {
	width: 70px;
}

#no {
	width: 50px;
}

#title {
	width: 150px;
}

#date {
	width: 100px;
}

#like {
	width: 50px;
}

#comment {
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
</style>
</head>
<body>

	<div class="inner" align="center">
		<div class="body">
			<br>
			<br>
			<ul>
				<li><a href="/myPage.me">내가 쓴 글</a></li>
				<li>내가 쓴 댓글</li>
				<li><a href="/member/modifyMember.me">회원정보 수정</a></li>
				<li><a href="/member/deleteMember.me">회원 탈퇴</a></li>
			</ul>
			<br> <br>
			<table align="center" border="1">
				<tr class="header">
					<td id="part">댓글번호</td>
					<td id="no">글번호</td>
					<td id="title">댓글 내용</td>
					<td id="date">작성일</td>
				</tr>
				<c:forEach items="${myCommentList }" var="myCommentList">
					<tr>
						<td>${myCommentList.commentNo }</td>
						<td>${myCommentList.boardNo }</td>
						<td>${myCommentList.commentContents }</td>
						<td>${myCommentList.commentDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="text-align:center" class="pi">
			<c:if test="${pi.startNavi gt 1 }">
				<button style="height:25px; width:55px">이전</button>
			</c:if>
			<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
				<c:url var="pagination" value="/member/myComment.me">
					<c:param name="page" value="${p }"></c:param>
				</c:url>
				<a href="${pagination }">${p }</a>&nbsp;
			</c:forEach>
			<c:if test="${pi.endNavi lt maxPage }">
				<button style="height:25px; width:55px">다음</button>
			</c:if>
		</div>
		<div class="footer">
			<button type="button" onclick="location.href='/'">홈으로</button>
			<button type="button" onclick="location.href='/member/logout.me'">로그아웃</button>		
		</div>
	</div>
</body>
</html>