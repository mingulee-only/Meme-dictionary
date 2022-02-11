<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
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
		<h3 align="center">아이디 찾기 결과</h3>
		<br><br>
		<table align="center">
			<tr align="center">
				<td><input type="text" name="memberId" value="${member.memberId }" readonly></td>
			</tr>
			<tr align="center">
				<td><button type="button" onclick="location.href='/login.me'">돌아가기</button></td>
			</tr>
		</table>
	</div>
</body>
</html>