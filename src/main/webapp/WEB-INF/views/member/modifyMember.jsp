<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

ul {
	list-style-type: none;
	padding-left: 150px;
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
			<br> <br>
			<ul>
				<li><a href="/myPage.me">내가 쓴 글</a></li>
				<li><a href="/member/myComment.me">내가 쓴 댓글</a></li>
				<li>회원정보 수정</li>
				<li><a href="/member/deleteMember.me">회원 탈퇴</a></li>
			</ul>
			<br> <br>
			<h3>회원정보 수정</h3>
			<form action="/member/modifyMember.me" method="POST">
				<table align="center">
					<tr>
						<td>아이디 <input type="text" name="memberId" readonly value="${member.memberId }"></td>
					</tr>
					<tr>
						<td>비밀번호 <input type="password" name="memberPw"></td>
					</tr>
					<tr>
						<td>이름 <input type="text" name="memberName" readonly value="${member.memberName }"></td>
					</tr>
					<tr>
						<td>닉네임 <input type="text" name="memberNickname" readonly value="${member.memberNickname }"></td>
					</tr>
					<tr>
						<td>이메일 <input type="text" name="memberEmail" value="${member.memberEmail }"></td>
					</tr>
					<tr>
						<td><button type="submit">정보수정</button></td>
					</tr>
				</table>
			</form>

		</div>
		<button type="button" onclick="location.href='/'">홈으로</button>
		<button type="button" onclick="location.href='/member/logout.me'">로그아웃</button>
	</div>
</body>
</html>