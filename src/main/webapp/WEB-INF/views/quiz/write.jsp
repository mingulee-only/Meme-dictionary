<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function(){
        var type = document.querySelector("#type");
        type.addEventListener("change", function() {
            console.log(type.innerHTML);
        });
    });
</script>
</head>
<body>
	<h1>유행어 등록</h1>
	<form action="/quiz/write.me" method="get">
	    <select name="quizType" id="type">
	        <option value="" selected disabled>유형선택</option>
	        <option value="O">OX퀴즈</option>
	        <option value="M">객관식퀴즈</option>
	        <option value="S">단답형퀴즈</option>
	    </select>
	    <br>
	    <textarea name="quizQuest" cols="50" rows="10" placeholder="문제를 입력 해주세요"></textarea><br><br>
	    <input type="text" name="quizAnswer" placeholder="정답을 입력 해주세요"><br>
	    <br>
	    <div id="choice">
	    	<input type="text" name="quiz_ch1" placeholder="보기를 입력 해주세요"><br>
	        <input type="text" name="quiz_ch2" placeholder="보기를 입력 해주세요">
	    </div>
	    <input type="submit" value="등록하기">
	    <input type="button" value="취소">
    </form>
</body>
</html>