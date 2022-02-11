<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
    	var $answer = []; // 정답 배열
    	var $quizNo = []; // 퀴즈번호 배열
    	var $quizType = []; // 퀴즈 유형
    	var $quizQuest = []; // 문제 배열
    	var $quizCh1 = []; // 객관식 배열
    	var $quizCh2 = []; // 객관식 배열
    	var $quizCh3 = []; // 객관식 배열
    	var $quizCh4 = []; // 객관식 배열
        var clock = 30; // 제한시간 설정
        var nextNum = 0; // 퀴즈 인덱스
        var userAnswer = []; // 유저가 입력한 정답
        var score = 0; // 점수
        var $report = [];
        
        getQuizNo();
        var time = setInterval(() => { // 타이머! 0초되면 결과로!
            if(clock>=0) {
                $("#time").html(clock);
                clock--;
            } else {
            	$("#quizNo_").val($report);
            	$("#quizQuest_").val($quizQuest);
            	$("#quizAnswer_").val($answer);
            	$("#userAnswer_").val(userAnswer);
            	$("#score_").val(score);
            	$("#quizCh1_").val($quizCh1);
            	$("#quizCh2_").val($quizCh2);
            	$("#quizCh3_").val($quizCh3);
            	$("#quizCh4_").val($quizCh4);
            	
            	
            	$("#postSubmit").submit();
            }
        }, 1000);

        // 엔터눌럿을때, 정답 칸에 값이 있을떄, 다음퀴즈 진행
        $(document).keyup(function(event) {
          	 if (event.keyCode == '13' && $('#answer').val() != '') {
          		nextQuiz();
          	   $('#answer').val("");
          	  }
          	  
          });
        
        // 랜덤으로 퀴즈번호 json으로 가져오기
        function getQuizNo() {
        	$.ajax({
				url : "/quiz/getRandom.me",
				type : "get",
				dataType : "json",
				success : function(data) {
					for(var i in data) {
						$quizNo[i] = data[i].quizNo;
					}
					getList();
				},
				error : function() {
					alert("ajax 실패!");
				}
			});
        }
        
        // 랜덤 퀴즈 번호로 퀴즈 리스트 json으로 가져오기
        function getList() {
        	if($quizNo[nextNum] != null) {
	        	$.ajax({
					url : "/quiz/getList.me",
					type : "get",
					dataType : "json",
					data : {"quizNo" : $quizNo[nextNum]},
					success : function(data) {
						for(var i in data) {
							$('#question').html(data[i].quizQuest);
							$('#ch1').html(data[i].quizCh1);
							$('#ch2').html(data[i].quizCh2);
							$('#ch3').html(data[i].quizCh3);
							$('#ch4').html(data[i].quizCh4);
							$answer[nextNum] = data[i].quizAnswer;
							$quizType[nextNum] = data[i].quizType;
							$quizQuest[nextNum] = data[i].quizQuest;
							$quizCh1[nextNum] = data[i].quizCh1;
							$quizCh2[nextNum] = data[i].quizCh2;
							$quizCh3[nextNum] = data[i].quizCh3;
							$quizCh4[nextNum] = data[i].quizCh4;
							$report[nextNum] = data[i].quizNo;
						}
					},
					error : function() {
						
					}
				});
        	}
        }
        
        // 정답 맞는지 체크하고 다음을 진행
        function nextQuiz() {
        	if($('#answer').val() == $answer[nextNum]) {
        		$('#whether').html("정답");
        		userAnswer[nextNum] =  $('#answer').val();
        		score++;
        	} else {
        		$('#whether').html("오답");
        		userAnswer[nextNum] =  $('#answer').val();
        	}
			nextNum++;
			getList();
			
			if($quizType[nextNum] != "M") {
				$('#ch1').html("");
				$('#ch2').html("");
				$('#ch3').html("");
				$('#ch4').html("");
			}
		}
    });
</script>
</head>
<body>
	<h1>랜덤 퀴즈</h1>
	제한시간 :
	<B><span id="time"></span></B> 초
	&nbsp;&nbsp;&nbsp;
	<B><span id="whether"></span></B>
	<br>
	<div id="quest">
		<b id="question"></b> <br>
		<div id="ch1"></div>
		<div id="ch2"></div>
		<div id="ch3"></div>
		<div id="ch4"></div>
		<br> <br> <br> <input type="text" id="answer" placeholder="정답 입력후 엔터">
	</div>
	<form action="/quiz/result.me" method="post" id="postSubmit">
		<input type="hidden" name="quizNo" id="quizNo_">
		<input type="hidden" name="quizQuest" id="quizQuest_">
		<input type="hidden" name="quizAnswer" id="quizAnswer_">
		<input type="hidden" name="quizCh1" id="quizCh1_">
		<input type="hidden" name="quizCh2" id="quizCh2_">
		<input type="hidden" name="quizCh3" id="quizCh3_">
		<input type="hidden" name="quizCh4" id="quizCh4_">
		<input type="hidden" name="userAnswer" id="userAnswer_">
		<input type="hidden" name="score" id="score_">
	</form>
</body>
</html>