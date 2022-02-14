<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
	.inner {
	position : absolute;
	width : 300px;
	height : 280px;
	top : 50%;
	left : 50%;
	margin-top : -140px;
	margin-left : -150px;
	background-color : lightgray;
	}
	.header ul {
	list-style-type : none;
	padding-left : 50px;
	}
	.header li {
	color : white;
	float : left;
	background-color : #4A4646;
	text-align : center;
	}
	.header li a {
	color : white;
	display : block;
	background-color : darkgray;
	text-decoration : none;
	text-align : center;
	}
	.header li a.current {
		color : white;
	}
	.header {
	height : 20%;
	margin-left : 20px;
	}
	.body {
	height : 80%;
	margin-top : 5px;
	}
</style>
</head>
<body>
	<div class="inner">
	<br><br>
		<div class="header">
			<ul>
				<li><a href="/member/findId.me">아이디 찾기</a></li>
				<li>비밀번호 찾기</li>
			</ul>
		</div>
		<div class="body">
			<form action="/member/findPw.me" method="post">
				<table align="center">
					<tr align="center">
						<td colspan="2"><input type="text" name="memberId" placeholder="아이디"></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="text" name="memberName" placeholder="이름"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="text" name="memberEmail" placeholder="이메일"></td>
					</tr>
					<tr align="center">
						<td>
							<button type="submit">비밀번호 찾기</button>
						</td>
						<td><button type="button" onclick="location.href='/login.me'">돌아가기</button>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>