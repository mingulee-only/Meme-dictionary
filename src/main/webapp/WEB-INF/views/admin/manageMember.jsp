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
	height: 80%;
}
.content {
	height : 80%;
	width : 80%;
}
.pi {
	height : 10%;
}
.footer {
	height : 10%;
}

ul {
	list-style-type: none;
	padding-left: 130px;
}

li {
	color: white;
	float: left;
	background-color: #4A4646;
	padding-right: 10px;
	text-align: center;
}

li a {
	color: white;
	display: block;
	background-color: darkgray;
	text-decoration: none;
	text-align: center;
}

li a.current {
	color: white;
}

#member-id {
	width: 35px;
}

#nickname {
	width: 50px;
}

#name {
	width: 150px;
}

#email {
	width: 100px;
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
				<li>회원 관리</li>
				<li><a href="/admin/manageMeme.me">유행어 사전 관리</a></li>
				<li><a href="/admin/manageBoard.me">추진/자유게시판 관리</a></li>
				<li><a href="/admin/manageQuiz.me">퀴즈 관리</a></li>
			</ul>
			<br>
			<br>
			<div class="content">
				<table align="center" border="1">
					<tr class="header">
						<td id="member-id">아이디</td>
						<td id="nickname">닉네임</td>
						<td id="name">이름</td>
						<td id="email">이메일</td>
					</tr>
					<c:forEach items="${allMemberList }" var="allMemberList">
						<tr>
							<td>${allMemberList.memberId }</td>
							<td>${allMemberList.memberNickname }</td>
							<td>${allMemberList.memberName }</td>
							<td>${allMemberList.memberEmail }</td>
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
					<c:url var="pagination" value="/myPage.me">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }">${p }</a>&nbsp;
				</c:forEach>
				<c:if test="${pi.endNavi lt maxPage }">
					<button style="height:25px; width:55px">다음</button>
				</c:if>
			</div>
		</div>
		<div style="text-align:center" class="pi">
		</div>
		
		<div class="footer">
			<button type="button" onclick="location.href='/'">홈으로</button>
			<button type="button" onclick="location.href='/member/logout.me'">로그아웃</button>		
		</div>
	</div>
</body>
</html>