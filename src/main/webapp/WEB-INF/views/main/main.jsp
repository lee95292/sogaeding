<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/resources/css/SlideCss/demo.css" />
    	<link rel="stylesheet" type="text/css" href="/resources/css/SlideCss/backgroundTransition.css" />
		<title>PlayMate 학습관리시스템</title>
		<style>
		.backgroundTransition .initial {
		
		}
		</style>
	</head>
	<body style="overflow:hidden;">
		<div class="backgroundTransition">
          <div class="content">
         
            <div class="login">
             <!-- logo 들어가기 -->
            <div class="login_logo">
            	<img id="logo" src="/resources/imgs/logo/logo.jpg" height=250px width=250px>
            </div>
            <!--  login id/pw -->
            <div class="login_idpw">
            	<form action="/do_login" method="POST">
            		<div class="login_item">
           				<input id="input_id" type="text" name="id" />		
            		</div>
            		<div class="login_item">
            			<input id="input_pw" type="password" name="password" autocomplete="off" />
            		</div>
            		<ul class="go_link">
	         		    <li><a href="/member/signup">회원가입</a></li>
	        		    <li><a href="#">ID찾기</a></li>
	       			    <li><a href="#">PW찾기</a></li>
	      			</ul>
	      			<div class="login_btn">
            			<input type="submit" value="로그인" />
	      			</div>
            	</form>
            </div>
            
         	</div>
       	</div>
      </div>

	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="/resources/js/SlideJs/backgroundTransition.js"></script>

	<script type="text/javascript">
	  $(document).ready(function(){
		  $('.backgroundTransition').backgroundTransition({
			  backgrounds:[
				  <c:forEach var="background" begin="1" end="4" >
 					{ src: '/resources/imgs/background/background-0<c:out value="${background}"/>.jpg'}
			      </c:forEach>
			  ],
			  transitionDelay: 3,
			  animationSpeed: 850
		  });
	  });
	</script>
	</body>
</html>