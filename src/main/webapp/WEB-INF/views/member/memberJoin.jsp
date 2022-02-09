<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<td colspan="2"><input type="password" name="user-pw" id="user-pw" placeholder="비밀번호"></td>	
				</tr>
				<tr align="center">
					<td colspan="2"><input type="password" name="user-pw-check" id="user-pw-check" placeholder="비밀번호 확인"></td>	
				</tr>
				<tr align="center">
					<td><input type="text" name="user-name" placeholder="이름" size="6"></td>
					<td><input type="text" name="user-nickname" placeholder="닉네임" size="6"></td>
				<tr align="center">
					<td colspan="2"><input type="text" name="user-email" placeholder="이메일"></td>
				</tr>
				<tr></tr>
				<tr align="center">
					<td id="join-button">
<!-- 						<input type="submit" value="회원가입"> -->
					</td>
					<td><button type="button" onclick="location.href='/login.oj'">돌아가기</button>
				</tr>
			</table>
		</form>
	</div>
	
	
	<script>
		$(document).ready(function(){
			var items = document.getElementsByTagName('td');
			items[0].innerHTML = "";
			$("#user-pw").keyup(function(){
				$("#join-button").innerHTML = "<button name='not-same'>회원가입</button>";
			});
			
			$("#user-pw-check").keyup(function(){
				
				if($("#user-pw").val() != $("#user-pw-check").val()){
					$("#join-button").innerHTML = "<button name='not-same'>회원가입</button>";
				}else {
					$("#join-button").innerHTML = "<input type='submit' value='회원가입'>";
				}
			});
			
			$("#not-same").onclick(function(){
				alert("비밀번호가 일치하지 않습니다.");
			});
		});
	</script>
</body>
</html>