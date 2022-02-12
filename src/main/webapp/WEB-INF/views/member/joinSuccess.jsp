<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
<style>
	.inner {
		position : absolute;
		width : 300px;
		height : 180px;
		top : 50%;
		left : 50%;
		margin-top : -90px;
		margin-left : -150px;
		background-color : lightgray;
		}
</style>
</head>
<body>
	<div class="inner">
		<h3 align="center">회원가입 성공!</h3>
		<br><br>
		<table align="center">
			<tr align="center">
				<td colspan="2"><button type="button" onclick="location.href='/login.me'">로그인 화면으로 돌아가기</button></td>
			</tr>
		</table>
	</div>
</body>
</html>