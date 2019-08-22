<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible">
    <title>PlayMate</title>
    <!-- Boot Strap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.js">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Basic|M+PLUS+Rounded+1c&display=swap" rel="stylesheet">
	<!--  main css -->
	<link rel="stylesheet" href="/resources/css/class/main.css" >
	<link rel="stylesheet" href="/resources/css/class/youtube.css" >
	<!-- contents css -->
	<link rel="stylesheet" href="/resources/css/class/contents.css" >
	<!-- 캘린더 css -->
	<link rel="stylesheet" href="/resources/css/calendarCss/pignose.calendar.css">
	<!--  main js -->
	 <script src="/resources/js/class/main.js"></script>
	 
</head>
<body>
        <jsp:include page="../modules/header_modules.jsp" flush="false"/>
        <!-- container -->
        <div id="e_class_contents"class="container-fluid">
			 <div class="row">
			 	<!-- 왼쪽 단 -->
			 	<!-- 왼쪽 단 -->
			 	<!-- 왼쪽 단 -->
			    <div class="col">
			      <!-- 교실 title  -->
			      <jsp:include page="../modules/class_title.jsp" flush="false"/>
			   	  <br>
			   	  <br>
			      <!--  달력 / 시간표  --> 
			     <jsp:include page="../modules/date_module.jsp" flush="false"/>
			    </div>
			    <!-- 중간 단 main content -->
			    <!-- 중간 단 main content -->
			    <!-- 중간 단 main content -->
			    <div class="col col-7 " id="main_content_html">
			    	<!--  수업공지사항  -->
			    	<div class="alert" style="
					    padding: 0;
					   
					    height: 100%;
					    margin: 0 auto;
					">
								   			<div class="upload" style="
								   			border-radius:20px;
								   			margin-bottom: 20px;
								   			height: 30%;
								   			border: 1px solid #e4e9a4;
								   			width: 100%;
								   			background-color: #f8f9fa!important;
					">
						<textarea name="textarea" id="textarea" col="8" row="10" style="
    border-radius: 10px;
    position: relative;
    height: 80%;
    width: 80%;
    top: 20px;
    left: 20px;
    /* margin: 4.5% auto 4.5% 3%; */
    float: left;
">    
</textarea>
<div class="area_btn" style="
    background: orangered;
    line-height: 140px;
    border-radius: 10px;
    text-align: center;
    float: right;
    border: 1px solid gray;
    color: #fff;
    width: 10%;
    height: 80%;
    /* float: right; */
    right: 0;
    top: 20px;
    position: relative;
    right: 20px;
   
">올리기</div>

</div>
			   			<div class="views">
				   			<div class="item" style="border-radius:20px; border:1px solid gray;
				   			height:150px; margin-bottom:20px"></div>
				   			<div class="item" style="border-radius:20px; border:1px solid gray
				   			;height:150px; margin-bottom:20px"></div>
			   				<!-- 뷰 -->
			   			</div>
			    	</div>
			    	<!--  ========   -->
			    </div>
			    <!-- 오른쪽 단  -->
			    <!-- 오른쪽 단  -->
		        <!-- 오른쪽 단  -->
			    <div class="col">
			    <!-- 학생일 경우  -->
			      <jsp:include page="../modules/student_content.jsp" flush="false"/>
			    <!--  교사일 경우 -->
			   <%--   <jsp:include page="../modules/teacher_content.jsp" flush="false"/> --%>
			   
			   <br>
			   <br>
			    <!--  링크 모듈 -->  
			      <jsp:include page="../modules/link_sites.jsp" flush="false"/>
			    </div>
			  </div>
		</div>
		<div id="e_room_contents"class="container-fluid">
			<jsp:include page="../modules/youtube.jsp" flush="false"/> 
		</div>
		<!--  user-info -->
        <div id="user-info" class="container-fluid" class="padding:0 15px;"></div>
</body>
<script>
//메뉴 버튼 클릭 

$(document).ready(()=>{
	$('#e_room_contents').addClass('nodisplay');
	var maxheight = $(window).height()*5/6;
	$('.col').css({'height':maxheight});
	
});
$(window).resize(function(){
	var maxheight = $(window).height()*5/6;
	$('.col').css({'height':maxheight});
});
$('#e_room.nav-link').mousedown(()=>{
	$('#e_room_li').addClass('active');
	$('#e_class_li').removeClass('active');
	$('.navbar').css({'border-bottom':'2px solid #DF6055'});
	$('#e_class_contents').addClass('nodisplay');
	$('#e_room_contents').removeClass('nodisplay');
});
$('#e_class.nav-link').mousedown(()=>{
	$('#e_class_li').addClass('active');
	$('#e_room_li').removeClass('active');
	$('.navbar').css({'border-bottom':'2px solid #C5CB4B'});
	$('#e_room_contents').addClass('nodisplay');
	$('#e_class_contents').removeClass('nodisplay');
});
</script>
</html>