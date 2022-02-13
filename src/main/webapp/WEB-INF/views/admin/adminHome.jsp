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
	background-color: white;
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

#part {
	width: 35px;
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
#delete {
	width: 35px;
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
				<li><a href="/admin/manageMember.me">회원 관리</a></li>
				<li><a href="/admin/manageMeme.me">유행어 사전 관리</a></li>
				<li><a href="/admin/manageBoard.me">추진/자유게시판 관리</a></li>
				<li><a href="/admin/manageQuiz.me">퀴즈 관리</a></li>
			</ul>
			<br>
			<br>
			<div class="content">
			<br><br>
				<h2>관리자 페이지에 오신것을<br>
					환영합니다.</h3>			
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