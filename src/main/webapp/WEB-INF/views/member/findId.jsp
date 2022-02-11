<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
	.inner {
	position : absolute;
	width : 300px;
	height : 250px;
	top : 50%;
	left : 50%;
	margin-top : -125px;
	margin-left : -150px;
	background-color : lightgray;
	}
	ul {
	list-style-type : none;
	padding-left : 50px;
	}
	li {
	color : white;
	float : left;
	background-color : #4A4646;
	text-align : center;
	}
	li a {
	color : white;
	display : block;
	background-color : darkgray;
	text-decoration : none;
	text-align : center;
	}
	li a.current {
		color : white;
	}
</style>
</head>
<body>
	<div class="inner">
	<br><br>
		<ul>
			<li>아이디 찾기</li>
			<li><a href="/member/findPw.me">비밀번호 찾기</a></li>
		</ul>
		<br><br>
		<form action="/member/findId.me" method="post">
			<table align="center">
				<tr align="center">
					<td colspan="2"><input type="text" name="memberName" placeholder="이름"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="memberEmail" placeholder="이메일"></td>
				</tr>
				<tr align="center">
					<td>
						<input type="submit" value="아이디 찾기">
					</td>
					<td><button type="button" onclick="location.href='/login.me'">돌아가기</button>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>