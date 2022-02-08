<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
        var clock = 5; // 제한시간 설정
        var answer = "";

        var time = setInterval(() => {
            if(clock>=0) {
                $("#time").html(clock);
                clock--;
            }
        }, 1000);

        	$(document).keyup(function(event) {
          	  if (event.keyCode == '13' && $('#answer').val() != '') {
          	    answer = $('#answer').val();
          	    
          	  }
          	});
    });
</script>
</head>
<body>
	<h1>유행어 풀기</h1>
    제한시간 : <B><span id="time"></span></B> 초<br>
	<div id="quest">
        <b id="question">1111</b>
        <br>
        <div id="choise" style="display: none;">
            <div id="ch1"></div>
            <div id="ch2"></div>
            <div id="ch3"></div>
            <div id="ch4"></div>
        </div>
        <br><br><br>
        <input type="text" id="answer" placeholder="정답 입력후 엔터">
    </div>
</body>
</html>