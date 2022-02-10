<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
#boardWriteTable { 
	width: 95%; 
	height: 200px; 
	background-color: #eeeeee; 
 	border: 1px solid black; 
	text-align: center;
 	margin: auto; 
}

th {
	background-color: #eeeeee;
}

.jb-th-1 {
	height: 500px;
	text-align: center;
}

.textInput2{
	padding-top: 80px;
	height: 500px;
	width: 99%;
}

</style>

</head>

<body>
	<h1 align="center">글쓰기</h1>
	<form action="/board/register" method="post">
		<table id="boardWriteTable" align="center" border="1">
			<tr>
				<td align="left">
				&nbsp&nbsp추진<input type="radio" name="boardType" value="P">
				&nbsp&nbsp자유<input type="radio" name="boardType" value="F" checked="checked"> 	
				</td>
			<tr>
				<td align="left">&nbsp<input type="file" name="filename"></td>
			</tr>
			</tr>
			<tr style="text-align: center">
				<td>
					<input type="text" name="boardTitle" value="" placeholder="글 제목"
						style="width: 99%">
				</td>
			</tr>
			<tr>
				<td class="jb-th-1">
					<input type="text" name="boardContents" value="" class="textInput2"
						placeholder="원하는 글 내용 적기">
				</td>
			</tr>
				<td colspan = "2" align="right" height="30px">
					<input type="reset" value="취소">
					<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>