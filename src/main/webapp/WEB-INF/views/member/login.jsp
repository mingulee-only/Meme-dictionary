<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
	.inner {
/* 		position : absolute; */
		width : 300px;
		height : 200px;
		text-align: center;
	 	margin: auto; 
		background-color : lightgray;
		
		margin-top : 10%;
		margin-bottom : 10%;
		margin-left : 35%;
	}
 	.header {
 		height : 20%;
 	}
 	.body {
	 	height : 80%;
	 	padding-left : 50px;
		margin-top : 20px;
	}
	
	#memberLoginTable {
		text-align: center;
	 	margin: auto; 
	 	margin-top : 0%;
	}
</style>
</head>
<body>
	<div class="inner">
	<br>
		<h3 align="center">로그인</h3>
		<form action="/member/login.me" method="post">
			<table id="memberLoginTable">
				<tr>
					<td colspan="2"><input type="text" name="memberId" placeholder="아이디"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" name="memberPw" placeholder="비밀번호"></td>	
				</tr>
				<tr>
					<td><input type="submit" value="로그인"></td>
					<td><button type="button" onclick="location.href='/member/join.me'">회원가입</button>
				</tr>
				<tr>
					<td colspan="2"><button type="button" onclick="location.href='/member/findId.me'">아이디/비밀번호 찾기</button></td>
				</tr>
			</table>	
		</form>
	</div>
</body>
</html>