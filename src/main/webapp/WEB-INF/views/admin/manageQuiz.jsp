<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
.inner {
	position: absolute;
	width: 700px;
	height: 600px;
	top: 50%;
	left: 50%;
	margin-top: -250px;
	margin-left: -350px;
	background-color: lightgray;
}

.body {
	height: 80%;
}
.content {
	height : 80%;
	width : 80%;
}
.pi {
	height : 10%;
}
.footer {
	height : 10%;
}

.body ul {
	list-style-type: none;
	padding-left: 130px;
}

.body li {
	color: white;
	float: left;
	background-color: #4A4646;
	padding-right: 10px;
	text-align: center;
}

.body li a {
	color: white;
	display: block;
	background-color: darkgray;
	text-decoration: none;
	text-align: center;
}

.body li a.current {
	color: white;
}

#part {
	width: 40px;
	text-align: center;
	font-size: smaller;
}

#no {
	width: 35px;
	text-align: center;
	font-size: smaller;
}

#question {
	width: 250px;
	text-align: center;
	font-size: smaller;
}

#writer {
	width: 100px;
	text-align: center;
	font-size: smaller;
}

#date {
	width: 50px;
	text-align: center;
	font-size: smaller;
}


.header {
	color: white;
	background-color: #4A4646;
	height: 30px;
}

.sub {
	font-size: smaller;
}
</style>
</head>
<body>


	<div class="inner" align="center">
		<div class="body">

			<br>
			<br>
			<ul>
				<li><a href="/admin/manageMember.me">회원 관리</a></li>
				<li><a href="/admin/manageMeme.me">유행어 사전 관리</a></li>
				<li><a href="/admin/manageBoard.me">추진/자유게시판 관리</a></li>
				<li>퀴즈 관리</li>
			</ul>
			<br>
			<ul class="sub">
				<li>전체 퀴즈 목록</li>
				<li><a href="/admin/manageQuizReported.me">신고된 퀴즈 목록</a></li>
			</ul>
			<br>
			<div class="content">
				<table align="center" border="1">
					<tr class="header">
						<td id="part">유형</td>
						<td id="no">번호</td>
						<td id="question">퀴즈내용</td>
						<td id="answer">정답</td>
						<td id="writer">출제자</td>
						<td id="date">작성일</td>
					</tr>
					<c:forEach items="${allQuizList }" var="allQuizList">
						<tr>
							<td id="part">
								<c:if test="${allQuizList.quizType eq 'O'}">
			    					O/X
								</c:if>
								<c:if test="${allQuizList.quizType eq 'S'}">
			    					단답형
								</c:if>
								<c:if test="${allQuizList.quizType eq 'M'}">
			    					객관식
								</c:if>
							</td>
							<td id="no">${allQuizList.quizNo }</td>
							<td id="question"><a href="../quiz/modifyView.me?quizNo=${allQuizList.quizNo }">${allQuizList.quizQuest }</a></td>
							<td id="answer">${allQuizList.quizAnswer }</td>
							<td id="writer">${allQuizList.memberId }</td>
							<td id="date">${allQuizList.quizDate }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="text-align:center" class="pi">
				<c:if test="${pi.startNavi gt 1 }">
					<button style="height:25px; width:55px">이전</button>
				</c:if>
				<c:forEach var="p" begin="${pi.startNavi }" end="${pi.endNavi }">
					<c:url var="pagination" value="/admin/manageQuiz.me">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }">${p }</a>&nbsp;
				</c:forEach>
				<c:if test="${pi.endNavi lt maxPage }">
					<button style="height:25px; width:55px">다음</button>
				</c:if>
			</div>
		</div>
		
		<div class="footer">
			<button type="button" onclick="location.href='/'">홈으로</button>
			<button type="button" onclick="location.href='/member/logout.me'">로그아웃</button>		
		</div>
	</div>
</body>
</html>