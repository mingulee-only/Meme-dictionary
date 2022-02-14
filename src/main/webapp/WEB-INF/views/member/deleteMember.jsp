<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	.inner {
	position : absolute;
	width : 700px;
	height : 500px;
	top : 50%;
	left : 50%;
	margin-top : -250px;
	margin-left : -350px;
	background-color : lightgray;
	}
	.body {
	height : 90%;
	}
	.body ul {
	list-style-type : none;
	padding-left : 150px;
	}
	.body li {
	color : white;
	float : left;
	background-color : #4A4646;
	padding-right : 10px;
	text-align : center;
	}
	.body li a {
	color : white;
	display : block;
	background-color : darkgray;
	text-decoration : none;
	text-align : center;
	}
	.body li a.current {
		color : white;
	}
	#part {
	width : 35px;
	}
	#no {
	width : 50px;
	}
	#title {
	width : 150px;
	}
	#date {
	width : 100px;
	}
	#like {
	width : 50px;
	}
	#comment {
	width : 50px;
	}
	
	
	.header {
	color : white;
	background-color : #4A4646;
	height : 30px;
	}
	
	.sub {
	font-size : smaller;
	
	}
	
	.content {
	padding-top : 10px;
	width : 80%;
	height : 70%;
	background-color : white;
	}
	
	.content_body {
	background-color : lightgray;
	width : 80%;
	height : 40%;
	padding-top : 5px;
	}
	
</style>
</head>
<body>
	
	<div class="inner" align="center">
		<div class="body">
			<br> <br>
			<ul>
				<li><a href="/myPage.me">내가 쓴 글</a></li>
				<li><a href="/member/myComment.me">내가 쓴 댓글</a></li>
				<li><a href="/member/modifyMember.me">회원정보 수정</a></li>
				<li>회원 탈퇴</li>
			</ul>
			<br> <br>
			<div class="content">
				<h3>회원 탈퇴</h3>
				<div class="content_body">
					<h4>사용하고 계신 아이디는 탈퇴를 할 경우, <br>
					재사용 및 복구가 불가능합니다.<br>
					탈퇴 후 회원정보와 이용기록 모두 삭제되고,<br>
					이 서비스를 이전과 같이 이용하실 수 없습니다.
					</h4>
				</div>
				<br>
				<input type="checkbox" id="check_delete"> 안내사항을 확인하였으며, 이에 동의합니다.
				<br><br>
				<button onclick="deleteButton();">회원 탈퇴</button>
			</div>
		</div>
		
		
		<button type="button" onclick="location.href='/'">홈으로</button>
		<button type="button" onclick="location.href='/member/logout.me'">로그아웃</button>
	</div>
	
<script>
	function deleteButton() {
		var test = document.getElementById("check_delete");
		if(test.checked == true) {
			location.href="/member/remove.me?memberId=${loginMember.memberId }";
		}else {
			alert("동의에 체크해주세요!");
		}
		
	}
</script>
</body>
</html>