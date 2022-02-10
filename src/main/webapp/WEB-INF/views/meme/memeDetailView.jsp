<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사전 상세 페이지</title>
</head>
<body>
	<br>
	<br>
	<h1 align="center">MEME DICTIONARY</h1>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<table align="center" border=1>
		<tr>
			<td>유행어</td>
			<td>${meme.memeName}</td>
		</tr>
		<tr>
			<td>유행시기</td>
			<td>${meme.memeDate}</td>
		</tr>
		<tr>
			<td height="300">유행어 설명</td>
			<td>${meme.memeContents}</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				 ${memeFile.memeFileName } 
			</td>
		</tr>
		<tr>
			<td>등재요청자</td>
			<td>${meme.memberNickname}</td>
		</tr>
	</table>
	<br>
	<br>
	<hr>
	<a href="/meme/modifyView?memeName=${meme.memeName}">의견내기</a>

<!-- 	<script>
		function requestMeme(){
			var requestValue = document.querySelector("#")
			location.href = '/meme/modifyView?memeName=' + requestValue;
		}
	</script>
 -->

</body>
</html>