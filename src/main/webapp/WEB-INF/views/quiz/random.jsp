<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
    	getQuizList();
    	
        var clock = 5; // 제한시간 설정
        var answer = "";
        var time = setInterval(() => {
            if(clock>=0) {
                $("#time").html(clock);
                clock--;
            }
        }, 1000);

        // 엔터눌럿을때 정답 비교
        $(document).keyup(function(event) {
          	 if (event.keyCode == '13' && $('#answer').val() != '') {
          	   console.log("test");
          	   $('#answer').val("");
          	 }
          	  
          });
        
        function getQuizList() {
        	$.ajax({
				url : "/quiz/getRandom.me",
				type : "get",
				dataType : "json",
				success : function(data) {
//                     var quizNo;
// 					for(var i in data) {
// 						quizNo+= data[i];
// 					}
					console.log(data.length);
					console.log(data);
				},
				error : function() {
					alert("ajax 실패!");
				}
			});
        }
        	
    });
</script>
</head>
<body>
	<h1>유행어 풀기</h1>
    제한시간 : <B><span id="time"></span></B> 초<br>
	<div id="quest">
        <b id="question"></b>
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