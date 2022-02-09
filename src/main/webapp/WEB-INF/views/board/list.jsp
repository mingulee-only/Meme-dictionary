<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	#boardTable{
		border: 1px solid black;
		width:800px;
		text-align: center;
		margin: auto;
	}
	
	#boardTable th, td{
		border: 1px solid black;
	}
	
</style>
</head>
<body>
	<h1 align="center">게시판</h1>
	<p align="right">
		<input type="button" value="글쓰기" />
	</p>
	<table id="boardTable">
		<tr>
			<th>번호</th>
			<th>분류</th>
			<th width="400px">글제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
		</tr>

		<c:forEach items="${boardAllList }" var="boardAllList">
			<tr>
				<td>${boardAllList.boardNo }</td>
				<td>
					<c:if test="${boardAllList.boardType eq 'P'}">
    					추진
					</c:if>
					<c:if test="${boardAllList.boardType eq 'F'}">
    					자유
					</c:if>
				</td>
				<td width="400px">${boardAllList.boardTitle }</td>
				<td>${boardAllList.memberNickname }</td>
				<td>${boardAllList.boardDate }</td>
				<td>${boardAllList.boardCount }</td>
			</tr>
		</c:forEach>
		
	</table>
	<br>
	<br>
	
	<div>
	<div style="text-align:center">
	<button style="height:25px; width:55px"  >이전</button>
	<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
		<c:url var="pagination" value="/board">
			<c:param name="page" value="${p }"></c:param>
		</c:url>
		<a href="${pagination }">${p }</a>&nbsp;
	</c:forEach>
	<button style="height:25px; width:55px">다음</button>
	</div>
	</div>
	<br>
	<div>
		<div style="text-align:center">
			<select style="height:30px; width:80px">
				<option value="0" style="text-align: center">분류</option>
				<option value="F" style="text-align: center">자유</option>
				<option value="P" style="text-align: center">추진</option>
				<option value="title" style="text-align: center">글제목</option>
				<option value="writer" style="text-align: center">작성자</option>
				<input type="text" name="keyword" style="height:30px; width:250px">
				<button style="height:30px; width:100px">Search</button>
			</select>
			
		</div>
	</div>
</body>
</html>