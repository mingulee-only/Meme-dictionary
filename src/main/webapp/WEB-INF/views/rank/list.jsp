<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퀴즈</title>
<style>
	html,body {width:100%;  }
	body,div,ul,li{margin:0; padding:0;}
	ul,li {list-style:none;}
	
	/*tab css*/
	.tab{float:left; width:600px; height:290px;}
	.tabnav{font-size:0; width:600px; border:1px solid #ddd;}
	.tabnav li{display: inline-block;  height:46px; text-align:center; border-right:1px solid #ddd;}
	.tabnav li a:before{content:""; position:absolute; left:0; top:0px; width:100%; height:3px; }
	.tabnav li a.active:before{background:#7ea21e;}
	.tabnav li a.active{border-bottom:1px solid #fff;}
	.tabnav li a{ position:relative; display:block; background: #f8f8f8; color: #000; padding:0 30px; line-height:46px; text-decoration:none; font-size:16px;}
	.tabnav li a:hover,
	.tabnav li a.active{background:#fff; color:#7ea21e; }
	.tabcontents{padding: 20px; height:244px; border:1px solid #ddd; border-top:none;}
</style>
</head>
<body>
	<div class="tab">
	  <ul class="tabnav">
	    <li><a href="tab1">유행어랭킹</a></li>
	    <li><a href="tab2">유행어추진랭킹</a></li>
	    <li><a href="tab3">자유게시판랭킹</a></li>
	    <li><a href="tab4">퀴즈랭킹</a></li>
	  </ul>
	  <div class="tabcontents">
	    <div id="tabcontent1">tab1 content</div>
	    <div id="tabcontent2">tab2 content</div>
	    <div id="tabcontent3">tab1 content</div>
	    <div id="tabcontent4">tab2 content</div>
	  </div>
	</div><!--tab-->
	<script>
		$(function() {
			$('.tabcontent > div').hide();
			$('.tabnav a').click(function() {
				$('.tabcontent > div').hide().filter(this.hash).fadeIn();
				$('.tabnav a').removeClass('active');
				$(this).addClass('active');
				return false;
			}).filter(':eq(0)').click();
		});
	</script>
</body>
</html>