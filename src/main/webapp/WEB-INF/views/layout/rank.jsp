<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랭킹</title>
<style>
	*{
	  margin:0; padding:0;
	  font-size:15px; 
	  line-height:1.3;
	  top: 50%;
	}
	ul{list-style:none;}
	
	.tabmenu{ 
	  max-width:300px; 
	  margin: 0 auto; 
	  position:relative; 
	}
	.tabmenu ul li{
	  display:  inline-block;
	  width:25%; 
	  float:left;  
	  text-align:center; 
	  background :#f9f9f9;
	  line-height:40px;
	}
	.tabmenu label{
	  display:block;
	  width:100%; 
	  height:40px;
	  line-height:40px;
	}
	.tabmenu input{display:none;}
	.tabCon{
	  display:none; 
	  text-align:left; 
	  padding: 20px;
	  position:absolute; 
	  left:0; top:40px; 
	  box-sizing: border-box; 
	  border : 5px solid #f9f9f9;
	  width : 100%;
	}
	.tabmenu input:checked ~ label{
	  background:#ccc;
	}
	.tabmenu input:checked ~ .tabCon{
	  display:block;
	}
	table {
		text-align : center;
	}
</style>
</head>
<body>
	<div class="tabmenu">
  <ul>
    <li id="tab1" class="btnCon"> <input type="radio" checked name="tabmenu" id="tabmenu1">
      <label for="tabmenu1">유행어</label>
      <div class="tabCon">
      	<table align="center" border="1">
		<!-- 번호, 제목, 작성자, 날짜, 조회수, 첨부파일 -->
			<tr>
				<th width="50" >등수</th>
				<th width="250">유행어 이름</th>
			</tr>
			<c:forEach items="${memeRankList }" var="mList">
				<tr>
					<td>${mList.memeRank }</td>
					<td>${mList.memeName }</td>
				</tr>
			</c:forEach>
		</table>
      
      </div>
    </li>
    <li id="tab2" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu2">
      <label for="tabmenu2">추진</label>
      <div class="tabCon">
      	<table align="center" border="1">
		<!-- 번호, 제목, 작성자, 날짜, 조회수, 첨부파일 -->
			<tr>
				<th width="50" >등수</th>
				<th width="150">추진 유행어</th>
				<th width="100">추천수</th>
			</tr>
			<c:forEach items="${boardPushRankList }" var="bprList">
				<tr>
					<td>${bprList.boardRank }</td>
					<td>${bprList.boardTitle }</td>
					<td>${bprList.boardLike }</td>
				</tr>
			</c:forEach>
		</table>
      
      </div>
    </li>    
    <li id="tab3" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu3">
      <label for="tabmenu3">자유</label>
      <div class="tabCon">
      		<table align="center" border="1">
			<!-- 번호, 제목, 작성자, 날짜, 조회수, 첨부파일 -->
				<tr>
					<th width="50" >등수</th>
					<th width="150">글제목</th>
					<th width="100">추천수</th>
				</tr>
				<c:forEach items="${boardFreeRankList }" var="bfrList">
					<tr>
						<td>${bfrList.boardRank }</td>
						<td>${bfrList.boardTitle }</td>
						<td>${bfrList.boardLike }</td>
					</tr>
				</c:forEach>
			</table>
      </div>
    </li>
    <li id="tab4" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu4">
      <label for="tabmenu4">퀴즈</label>
      <div class="tabCon">
      	<table align="center" border="1">
		<!-- 번호, 제목, 작성자, 날짜, 조회수, 첨부파일 -->
			<tr>
				<th width="50" >등수</th>
				<th width="150">닉네임</th>
				<th width="100">점수</th>
			</tr>
			<c:forEach items="${quizRankList }" var="qrList">
				<tr>
					<td>${qrList.quizRank }</td>
					<td>${qrList.memberId }</td>
					<td>${qrList.quizBestscore }</td>
				</tr>
			</c:forEach>
			
		</table>
      </div>
    </li>
  </ul>
</div>
	

</body>
</html>