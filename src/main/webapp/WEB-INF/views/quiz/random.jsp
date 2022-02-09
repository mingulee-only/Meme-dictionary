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
    	var $quest =[]; // 문제 배열
    	var $answer = []; // 정답 배열
    	var $quizNo = []; // 퀴즈번호 배열
    	var $quizType = []; // 퀴즈 유형
        var clock = 5; // 제한시간 설정
        var nextNum = 0; // 퀴즈 인덱스
        var userAnswer = []; // 유저가 입력한 정답
        var score = 0; // 점수
        
		getQuizList();
        var time = setInterval(() => { // 타이머! 0초되면 결과로!
            if(clock>=0) {
                $("#time").html(clock);
                clock--;
            } else {
            	$("#quizNo_").val($quizNo);
            	$("#quizQuest_").val($quest);
            	$("#quizAnswer_").val($answer);
            	$("#userAnswer_").val(userAnswer);
            	$("#score_").val(score);
            	
            	
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
        
        // 랜덤으로 퀴즈 json으로 가져오기
        function getQuizList() {
        	$.ajax({
				url : "/quiz/getRandom.me",
				type : "get",
				dataType : "json",
				success : function(data) {
					for(var i in data) {
						$quest[i] = data[i].quizQuest;
						$answer[i] = data[i].quizAnswer;
						$quizNo[i] = data[i].quizNo;
						$quizType[i] = data[i].quizType;
					}
					$('#question').html($quest[nextNum]);
					getMList();
				},
				error : function() {
					alert("ajax 실패!");
				}
			});
        }
        
        // 객관식 문항 json으로 가져오기
        function getMList() {
        	$.ajax({
				url : "/quiz/getMList.me",
				type : "get",
				data : {"quizNo" : $quizNo[nextNum]},
				dataType : "json",
				success : function(data) {
					for(var i in data) {
						$("#ch1").html(data[i].quizCh1);
						$("#ch2").html(data[i].quizCh2);
						$("#ch3").html(data[i].quizCh3);
						$("#ch4").html(data[i].quizCh4);
					}
				},
				error : function() {
					alert("ajax 실패!");
				}
			});
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
        	
        	// 객관신인 경우 보기 문항 가져오기
        	if($quizType[nextNum] == "M") {
        		getMList();
        	} else {
        		$("#ch1").html("");
        		$("#ch2").html("");
        	}
        	
			nextNum++;
        	$('#question').html($quest[nextNum]);
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
		<div id="choise">
			<div id="ch1"></div>
			<div id="ch2"></div>
			<div id="ch3"></div>
			<div id="ch4"></div>
		</div>
		<br> <br> <br> <input type="text" id="answer" placeholder="정답 입력후 엔터">
	</div>
	
	<form action="/quiz/result.me" method="post" id="postSubmit">
		<input type="hidden" name="quizNo" id="quizNo_">
		<input type="hidden" name="quizQuest" id="quizQuest_">
		<input type="hidden" name="quizAnswer" id="quizAnswer_">
		<input type="hidden" name="userAnswer" id="userAnswer_">
		<input type="hidden" name="score" id="score_">
	</form>
</body>
</html>