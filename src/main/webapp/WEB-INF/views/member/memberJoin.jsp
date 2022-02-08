<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
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
</style>
</head>
<body>
	<div class="inner">
		<h3 align="center">회원가입</h3>
		<form action="/member/join.oj" method="post">
			<table align="center">
				<tr align="center">
					<td colspan="2"><input type="text" name="user-id" placeholder="아이디"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="password" name="user-pw" placeholder="비밀번호"></td>	
				</tr>
				<tr align="center">
					<td><input type="text" name="user-name" placeholder="이름" size="6"></td>
					<td><input type="text" name="user-nickname" placeholder="닉네임" size="6"></td>
				<tr align="center">
					<td colspan="2"><input type="text" name="user-email" placeholder="이메일"></td>
				</tr>
				<tr></tr>
				<tr align="center">
					<td><input type="submit" value="회원가입"></td>
					<td><button type="button" onclick="location.href='/login.oj'">돌아가기</button>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>