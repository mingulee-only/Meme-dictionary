<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<style>
	html, body {
		height: 100%;
		width: 100%;
		background-color: black;
	}
	#container {
		height:100%;
		width:100%;
		background-color: grey;
	}
	#header {
		height:20%;
		width:100%;
		background-color: grey;
	}
	#content {
		height : 80%;
		width: 100%;
		background-color: pink;
	}
	#body {
		margin-top: -10px
		height:100%;
		width:80%;
		background-color: gold;
		float:left;
	}
	#rank {
		height:100%;
		width:20%;
		background-color: #f9f9f9;
		float:left;
	}

</style>
</head>
<body>	

	<div id= "container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="content">
			<div id="body">
				<tiles:insertAttribute name="body" />
			</div>
			
			<div id="rank">
				<tiles:insertAttribute name="rank" />
			</div>
		</div>
	</div>
</body>
</html>