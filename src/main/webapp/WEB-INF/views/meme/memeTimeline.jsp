<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>timeline</title>
</head>
<body>
	<br>
	<br>
	<h1 align="center">TimeLine</h1>
	<br>
	<hr>
	<br>
	<h3>2000년 이전</h3>
	<c:forEach items="${memeTimeline }" var="tFirstList">
		<button>${tFirstList.memeName }</button>
	</c:forEach>
	<br>

	<h3>2001년 - 2005년</h3>
	<c:forEach items="${memeSecondTimeline }" var="tSecondList">
		<button>${tSecondList.memeName }</button>
	</c:forEach>
	<br>

	<h3>2006년 - 2010년</h3>
	<c:forEach items="${memeThirdTimeline }" var="tThirdList">
		<button>${tThirdList.memeName }</button>
	</c:forEach>
	<br>

	<h3>2011년 - 2015년</h3>
	<c:forEach items="${memeFourthTimeline }" var="tFourthList">
		<button>${tFourthList.memeName }</button>
	</c:forEach>
	<br>
	
	<h3>2016년 - 2020년</h3>
	<c:forEach items="${memeFifthTimeline }" var="tFifthList">
		<button>${tFifthList.memeName }</button>
	</c:forEach>
	<br>
	
	<h3>2021년</h3>
		<c:forEach items="${memeSixthTimeline }" var="tSixthList">
		<button>${tSixthList.memeName }</button>
	</c:forEach>
	<br>

	<script>

	</script>

</body>
</html>