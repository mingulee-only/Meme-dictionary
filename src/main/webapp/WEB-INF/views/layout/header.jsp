<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>유행어 사전</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="./resources/css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="./resources/css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="./resources/css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="./resources/images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="./resources/css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- fonts -->
      <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--  -->
      <!-- owl stylesheets -->
      <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
      <link rel="stylesheet" href="./resources/css/owl.carousel.min.css">
      <link rel="stylesheet" href="./resources/css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      
   </head>
   <body>
      <!-- banner bg main start -->
      <div class="bg">
         <!-- logo section start -->
         <div class="logo_section">
            <div class="container">
               <div class="row">
                  <div class="col-sm-12">
<!--                      <div class="logo"><a href="index.html"><img src="./resources/images/logo.png"></a></div> -->
					<div class="logo"></div>
                  </div>
               </div>
            </div>
         </div>
         <!-- logo section end -->
         <!-- header section start -->
         <div class="header_section">
            <div class="container">
               <div class="containt_main">
                  <div id="mySidenav" class="sidenav">
                     <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                     <a href="index.html">유행어사전</a>
                     <a href="fashion.html">유행어 추진/자유게시판</a>
                     <a href="electronic.html">유행어 퀴즈</a>
                     <a href="jewellery.html">타임라인</a>
                  </div>

                  <span class="toggle_icon" onclick="openNav()"><img src="./resources/images/toggle-icon.png" style="width: 35px"></span>
				  <div class="main"></div>
                  <div class="header_box">
<!--                   	 <div class=""><a href="#">MEME</a></div> -->
                     <div class="login_menu" >
                        <ul>
                           <li>
                           		<c:if test="${empty sessionScope.loginMember }">
	                     			<a href="/login.oj"><i class="fa fa-user fa-2x" aria-hidden="true"></i></a>
	                     		</c:if>
	                     		<c:if test="${not empty loginMember }">
	                     			<a href="/myPage.oj"><i class="fa fa-user fa-2x" aria-hidden="true"></i></a>
	                          	</c:if>
	                          	
                           </li>
                        </ul>
                     </div>
                  </div>
               </div>
               
              
            </div>
         </div>
         <!-- header section end -->
        
      </div>
      <!-- banner bg main end -->
      
      <!-- Javascript files-->
      <script src="./resources/js/jquery.min.js"></script>
      <script src="./resources/js/popper.min.js"></script>
      <script src="./resources/js/bootstrap.bundle.min.js"></script>
      <script src="./resources/js/jquery-3.0.0.min.js"></script>
      <script src="./resources/js/plugin.js"></script>
      <!-- sidebar -->
      <script src="./resources/js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="./resources/js/custom.js"></script>
      <script>
         function openNav() {
           document.getElementById("mySidenav").style.width = "250px";
         }
         
         function closeNav() {
           document.getElementById("mySidenav").style.width = "0";
         }
         
         function searchMeme(){
        	 var searchValue = document.querySelector("#keyword").value;
        	 location.href='/meme/detail?memeName='+searchValue;
         } 

         
      </script>
   </body>
</html>