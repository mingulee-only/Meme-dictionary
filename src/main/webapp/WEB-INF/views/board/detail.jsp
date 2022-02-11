<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> -->

<style>
     #boardDetailTable {
     	height:70px;
        width: 95%; 
		background-color: #eeeeee; 
		border: 1px solid black; 
		text-align: center;
		margin: auto; 
     }

	     #boardDetailTable tr {
	        border: 1px solid black; 
	     }
	
	#boardDetailTable2 {
		width: 95%; 
		background-color: white; 
	 	border: 1px solid black; 
		text-align: center;
	 	margin: auto; 
	 	border-bottom: 0pt;
	}
	    .jb-th-1 {
	        height: 300px;
	        width: 100%;
	        background-color: white;
	    }
	         
	#boardCommentTable {
		width: 95%; 
	 	border: 1px solid black; 
		text-align: center;
	 	margin: auto;
	 	background-color: white;
	}
	
	#boardCommentTable2 {
		width: 95%; 
	 	border: 1px solid black; 
		text-align: center;
	 	margin: auto;
	 	background-color: white;
	}


	    .textInput2 {
	        padding-top: 80px;
	    }
        
        p {
        	color: black;
        }
        
</style>

</head>

<body>
    <table id="boardDetailTable">
        <tr>
            <th width="10%">
            	<c:if test="${oneBoard.boardType eq 'P'}">
					추진
				</c:if>
				<c:if test="${oneBoard.boardType eq 'F'}">
					자유	
				</c:if>
			</th>
			
			<th colspan="2" width="90%">
				${oneBoard.boardTitle }
			</th>
			
		</tr>

		<tr>
			<td width="33%">글쓴이(닉네임) : ${oneBoard.memberNickname }</td>
			<td width="34%">작성날짜 : ${oneBoard.boardDate }</td>
			<td width="33%">조회수: ${oneBoard.boardCount }</td>
		</tr>
	</table>
	<table id="boardDetailTable2" >
	    <tr>
	        <td class="jb-th-1" align="left" valign="top">
	            <p>${oneBoard.boardContents }</p>
	    	</td>
		</tr>
	
		<tr height="100px">
			<td text align="center">
				<form action='<c:url value="/board/detail_like">
					<c:param name="boardNo" value="${oneBoard.boardNo }"></c:param>
					</c:url>' method="post">
					<c:if test="${empty sessionScope.loginMember }">
	           			추천
	           		</c:if>
	           		<c:if test="${not empty loginMember }">
	           			<input type="submit" id="recommand" value="추천">
	                </c:if>
<!-- 	                <input type="submit" id="recommand" value="추천"> -->
					<br>${oneBoard.boardLike }
				
				</form>
				
			</td>
		</tr>
	</table>

	
	<!-- 댓글 목록 -->
	<table id="boardCommentTable" border="1">
	    <tr>
	        <td>닉네임 : K</td>
	        <td>무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 <input type="button" id="Cinput" value="대댓글 입력"></td>
	        <td>22/01/26<br>00:01:01</td>
	    </tr>
	    <td>닉네임 : S</td>
	        <td>바람 서리 불변함은 우리 기상일세 
	            <input type="button" id="Cmodify" value="수정">
	            <input type="button" id="Cdelete" value="삭제">&nbsp;
	            <input type="button" id="Cinput" value="대댓글 입력">
	
	        </td>
	    <tr>
	        <td>닉네임 : S</td>
	        <td>남산 위에 저 소나무 철갑을 두른듯 
	            <input type="button" id="Cmodify" value="수정">
	            <input type="button" id="Cdelete" value="삭제">&nbsp;
	            <input type="button" id="Cinput" value="대댓글 입력">
	        </td>
	    </tr>
	</table>
	
	<!-- 댓글 등록 -->
	
	<table id="boardCommentTable2" border="1" width="95%">
		<tr>
			<td>
				<textarea rows="3" cols="55" id="commentContents" style="width: 100%; height: 80px;"></textarea>
			</td>
			<td>
				<input type="button" value="등록하기" id="cSubmit" style="width: 100%; height: 80px;" ></input>
			</td>
		</tr>
	</table>
	
	<script>

	$("#cSubmit").on("click", function(){
		var boardNo = "${oneBoard.boardNo }";
		var commentContents = $("#commentContents").val();
		$.ajax({
			url: "/board/commentAdd",
			type: "post",
			data: { "boardNo" : boardNo,
				"commentContents" : commentContents },
			success: function(){
				console.log("ajax 성공");
			},
			error: function(){
				console.log("ajax 실패");
			}
		});
	});
		
	</script>
</body>

</html>