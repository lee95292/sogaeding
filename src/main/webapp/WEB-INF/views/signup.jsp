<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PlayMate - 회원가입</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
		<!-- Boot Strap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- main css -->
		<link rel="stylesheet" href="/resources/css/SignUpCss/main.css">
		<!-- Jquery 1.12.4 -->
		<script
		 	 src="https://code.jquery.com/jquery-1.12.4.min.js"
		 	 integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		  	 crossorigin="anonymous"></script>
		<style>
			a:hover, a:focus {
				color:#fff !important;
				text-decoration:none !important;
			}
			.hiden {
				overflow: hidden !important;
				display:block !important;
			}
		</style>
	</head>
	<body>
	
		<!-- content img -->
		<div class="content content_img" style="overflow: hidden;">
			<img id="contentImg" src="/resources/imgs/background/signup-img.jpg" style="width:100%">
		</div>
		
		<!--  content -->
		<div id="content_wrap" class="content content_info">
			<h1 class="content_tit" style="margin:0;">회원가입</h1>
			<!--  type 선택하기  -->
			<div class="type_sel">
				<div class="type" id="type_admin" onclick="togglejoinType(this);">
    			 	관리자
    			 </div>
  		   		 <div class="type" id="type_teacher" onclick="togglejoinType(this);">
  		   			선생님
  		   		</div>
    			 <div class="type" id="type_student" onclick="togglejoinType(this);">
    			 	학생
    			 </div>
			</div>
			<!-- side title -->
			<div class="side_title">
				<h1>인증 및 회원정보 입력</h1>
				<span>Play Mate 가입을 위해서는 아래의 정보를 기입해주세요.</span>
			</div>
			
			<!-- type별 content내용 -->
			<div class="content_form">
				<form id="memberForm" name="memberForm" method="POST" action="/member/register">
					<input type="text" id="m_type" name="m_type" style="display:none;" disable >
					<!--  이름, 성별, 생년월일 -->
					<!--  이름, 성별, 생년월일 -->
					<!--  이름, 성별, 생년월일 -->
					<table class="write_tb mgt0">
						<colgroup>
							<col style="width:25%;">
							<col style="width:75%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">
									<span id="nameLabel">이름</span>
								</th>
								<td>
									<input type="text" id="name" class="w150 han" name="name" required>
								</td>
							</tr>
							<tr>
								<th scope="row"><span>성별</span></th>
								<td style="display:flex; width:100%;">
									<input type="radio" id="male" class="radio" name="gender" value="M" checked="checked"><label for="male">남</label>
									<input type="radio" id="female" class="radio" name="gender" value="F"><label for="female">여</label>
								</td>
							</tr>
							<tr>
								<th scope="row"><span>생년월일</span></th>
								<td>
									<span style="border:0" id="birth_id">
										<select name="birthY" id="birthY" class="w80">
											<option value="">년도</option>
											 <c:forEach var="Y" begin="0" end="70" >
											 		<option value="<c:out value="${2019-Y}"/>"><c:out value="${2019-Y}"/></option>
											 </c:forEach>	
										</select> 
										<select name="birthM" id="birthM" class="w70">
											<option value="">월</option>
											 <c:forEach var="M" begin="1" end="12" >
											 	<c:choose>
												 <c:when test="${M < 10 }">
												 	<option value="<c:out value="0${M}"/>"><c:out value="0${M}"/></option>
												 </c:when>
												 <c:otherwise>
												 	<option value="<c:out value="${M}"/>"><c:out value="${M}"/></option>
												 </c:otherwise>
												</c:choose>		
											 </c:forEach>	
										</select> 
										<select name="birthD" id="birthD" class="w70">
											<option value="">일</option>
											 <c:forEach var="D" begin="1" end="31" >
											 	<c:choose>
												 <c:when test="${D < 10 }">
												 	<option value="<c:out value="0${D}"/>"><c:out value="0${D}"/></option>
												 </c:when>
												 <c:otherwise>
												 	<option value="<c:out value="${D}"/>"><c:out value="${D}"/></option>
												 </c:otherwise>
												</c:choose>		
											 </c:forEach>					
										</select>
										<label for="birthY"></label>
										<label for="birthM"></label>
										<label for="birthD"></label>																												
										</span>
								</td>
							</tr>
						</tbody>
					</table>
					
					<!--  id, password, email -->
					<!--  id, password, email -->
					<!--  id, password, email -->
					<table class="write_tb">
						<colgroup>
							<col style="width:25%;">
							<col style="width:75%;">
						</colgroup>
						<tbody>
								<tr>
									<!--첫 목록 class:none-->
									<th scope="row"><label for="userId"><span>아이디</span></label></th>
									<td>
										<p class="groupId">
											* 4~12자의 영문소문자 또는 영문소문자 + 숫자를 입력해 주세요.
											<br><br>
											<input type="text" id="userId" name="userId" class="w160" style="ime-mode:disabled;" maxlength="12" required>
											<a href="javascript:void(0);" id="dpChk" class="btn_pop dupl" onclick="DubChkId();return false;">중복확인<span>&nbsp;</span></a><br>
										</p>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="password"><span>비밀번호</span></label></th>
									<td>
										<p class="exp2">
									</p><p class="passwordPolicyLi">
									    1. 비밀번호는 숫자, 영문 대/소문자, 특수문자 중 3가지를 조합하여 8~16자로 입력해주세요.
									</p>
									<p class="passwordPolicyLi2">
									    ※ 특수문자 예시 : ~, !, @, $, ^, *, _, +
									</p>
									<p class="passwordPolicyLi2">
									    ※ 비밀번호 예시 : 0079edunet! (숫자 + 특수문자 + 소문자), 1577@EDUNET (숫자 + 특수문자 + 대문자)
									</p>
									<p class="passwordPolicyLi">
									    2. 아이디, 생년월일, 전화번호 등 개인정보와 관련된 숫자, 연속된 숫자, 반복된 문자 등 다른 사람이 쉽게 알아낼 수 있는 비밀번호는 개인정보 유출의 위험이 높으므로 사용하지 않는 것이 좋습니다.
									</p>
											<br>
											<input type="password" id="password" name="password" class="w160" maxlength="16" size="30" required>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="repwd"><span>비밀번호 확인</span></label></th>
										<td><input type="password" id="repwd" class="w160" maxlength="16" size="30" onchange="Chkpwd()" required> <span class="level" id="password_equal"></span></td>
									</tr>
									<tr>
										<th scope="row"><label for="mob1"><span id="subEmailTitle">이메일</span></label></th>
										<td>
											<p class="exp2">* 이메일은 아이디 및 비밀번호 찾기에 필요한 정보이므로 정확하게 입력해 주시기 바랍니다.</p>
											<input type="text" id="subEmail1" name="subEmail1" class="w160" style="ime-mode:disabled;" required>@
											<input type="text" id="subEmail2" name="subEmail2" class="w160" style="ime-mode:disabled;" required>
											<select id="email2" name="email2" class="w160" onchange="emailAddGrade();">
												<option value="">직접입력</option>
												<option value="naver.com">naver.com</option>
												<option value="nate.com">nate.com</option>
												<option value="daum.net">daum.net</option>
												<option value="hotmail.com">hotmail.com</option>
												<option value="gmail.com">gmail.com</option>
											</select>
										<label for="subEmail1"></label>
										<label for="subEmail2"></label>
										<label for="email2"></label>
								</td>
							</tr>
						</tbody>
					</table>
					<!--  학생 추가정보  -->
					<div class="w100">
						<table id="schoolTable" class="write_tb" summary="학교(기관)명,학년 항목이 포함된 표입니다." style="display: table;">
							<caption class="hidden">회원정보입력</caption>
							<colgroup><col style="width:25%;">
							<col style="width:75%;">
							</colgroup><tbody>
								<tr>
									<th scope="row"><label for="sch_nm"><span>학교(기관)명</span></label></th>
									<td>
										<input type="text" name="sch_nm" id="sch_nm" class="w160 han" readonly="">
										<a href="javascript:void(0);" id="btnSearch" class="btn_pop sch" onclick="javascript:viewSchPop(); return false;">학교선택<span>&nbsp;</span></a>
										<select id="schoolGrade" class="w70" style="display:none">
											<option value="">선택</option>
											<option value="01">유치원</option>
											<option value="02">초등학교</option>
											<option value="03">중학교</option>
											<option value="04">고등학교</option>
											<option value="05">대학교</option>
											<option value="06">기타</option>
										</select>
									</td>
								</tr>
								<tr id="exsclyybb" style="display:none;">
									<th scope="row"><label for="exsclyybb"><span>학년/반</span></label></th>
									<td>
										<select id="exsclyy" class="w60" style="display:inline-block;">
											<option value="">선택</option>
										</select><label>학년</label>
										<select id="exsclbb" class="w60" style="display:inline-block;">
											<option value="">선택</option>
										</select><label>반</label>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- 버튼 -->
					<!-- 버튼 -->
					<div class="btn_wrap center">
						<div class="txtbtn txtbtn_j" onclick="join()"><span>가입</span></div>
						<div class="txtbtn txtbtn_cc" onclick="join_cancel()"><span>취소</span></div>
					</div>
				</form>
			</div>
		</div>
		<div class="findSch nodisplay">
			<div class="layerPopWrap" id="Schpop">
				<a href="javascript:closeSchPop();" class="close"><img src="/resources/imgs/icon/btn_quit.gif" alt="닫기"></a>
				<div class="viewArea">
					<div class="popTitle">
						<h4>학교 검색</h4>
					</div>
					<div class="popSearch">
						<select name="schl_name" id="schl_name">
								<option value="NEED">학교급</option>
								<!-- <option value="유치원">유치원</option> -->
							 	<option value="초등학교">초등학교</option>
								<option value="중학교">중학교</option>
								<option value="고등학교">고등학교</option>
								<!-- <option value="대학교">대학교</option>
								<option value="기타">기타</option> -->
						</select>
	    				<strong>학교(기관)명</strong>
	   					 <input type="text" id="popupSchInput" onkeypress="if(event.keyCode==13) {searchSchool();}">
	  					 <div class="popSearchBtn" onclick="searchSchool();">검색</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script> 
	$(document).ready(()=>{
		$('body').css({'overflow':'hidden'});
		var maxheight = $(window).height();
		$('#contentImg').css({'height':maxheight});
		$('#content_wrap').css({'height':maxheight,'overflow':'scroll'});
	});
	$(window).resize(function(){
		var maxheight = $(window).height();
		$('#contentImg').css({'height':maxheight});
		$('#content_wrap').css({'height':maxheight});
		$('.findSch').css({'height':maxheight});
	});
	
	// 아이디 중복 확인 
	function DubChkId() {
		//ajax 통신 필요 
	}
	
	// 가입 
	function join() {
		var type = $('#m_type').val();
		console.log(type);
		if(type=='' || type==undefined){
			window.alert('회원타입을 선택해주세요!! [관리자,선생님,학생]');
			
		}
		
	//	var form = document.memberForm;
	//	form.submit();

	}
	// 가입 취소 
	function join_cancel() {
		 $('#memberForm').each(function(){
			    this.reset();
		 });
		location.href="/";
	}
	// 이메일 기입 
	function emailAddGrade() {
		var email_addr = $('#email2').val();
		$('#subEmail2').val(email_addr);
		}
	// type 선택하기 
	function togglejoinType(obj) {
		var id = $(obj).attr('id');
		//console.log($('#'+id));
		switch(id){
		case 'type_admin':
			$('#'+id).css({"background-image":"url(/resources/imgs/icon/ic_admin_on.png)",'background-repeat':'no-repeat','background-color':'rgb(237,160,64)','color':'#fff'});
			$('#type_teacher').css({"background-image":"url(/resources/imgs/icon/ic_teacher.png)",'background-repeat':'no-repeat','background-color':'#fff','color':'rgb(51,125,192)'});
			$('#type_student').css({"background-image":"url(/resources/imgs/icon/ic_student.png)",'background-repeat':'no-repeat','background-color':'#fff','color':'rgb(74,166,157)'});
			$('#exsclyybb').css({"display":"none"});
			$('#nameLabel').text('이름');
			$('#m_type').val('admin');
			break;
		case 'type_teacher':
			$('#'+id).css({"background-image":"url(/resources/imgs/icon/ic_teacher_on.png)",'background-repeat':'no-repeat','background-color':'rgb(51,125,192)','color':'#fff'});
			$('#type_admin').css({"background-image":"url(/resources/imgs/icon/ic_admin.png)",'background-repeat':'no-repeat','background-color':'#fff','color':'rgb(237,160,64)'});
			$('#type_student').css({"background-image":"url(/resources/imgs/icon/ic_student.png)",'background-repeat':'no-repeat','background-color':'#fff','color':'rgb(74,166,157)'});
			$('#exsclyybb').css({"display":""});
			$('#nameLabel').text('이름');
			$('#m_type').val('teacher');
			break;
		case 'type_student':
			$('#'+id).css({"background-image":"url(/resources/imgs/icon/ic_student_on.png)",'background-repeat':'no-repeat','background-color':'rgb(74,166,157)','color':'#fff'});
			$('#type_admin').css({"background-image":"url(/resources/imgs/icon/ic_admin.png)",'background-repeat':'no-repeat','background-color':'#fff','color':'rgb(237,160,64)'});
			$('#type_teacher').css({"background-image":"url(/resources/imgs/icon/ic_teacher.png)",'background-repeat':'no-repeat','background-color':'#fff','color':'rgb(51,125,192)'});
			$('#exsclyybb').css({"display":""});
			$('#nameLabel').text('학생 이름');
			$('#m_type').val('student');
			break;
		}
	};
	
	</script>
	<script>
	//============== 키보드 예외처리 ================//
	const re = /[~!@\#$%;<>,?/"/^&*\()\-=+_']/gi; 
	$('#name').keyup(()=>{
		 var temp=$("#name").val();
		 if(re.test(temp)){ //특수문자가 포함되면 삭제하여 값으로 다시셋팅
			window.alert('특수문자는 들어갈 수 없습니다.');
		 $("#name").val(temp.replace(re,"")); } 
	});
	$('#userId').keyup(()=>{
		 var temp=$("#userId").val();
		 if(re.test(temp)){ //특수문자가 포함되면 삭제하여 값으로 다시셋팅
			window.alert('특수문자는 들어갈 수 없습니다.');
		 $("#userId").val(temp.replace(re,"")); } 
	});
	$('#subEmail1').keyup(()=>{
		 var temp=$("#subEmail1").val();
		 if(re.test(temp)){ //특수문자가 포함되면 삭제하여 값으로 다시셋팅
			window.alert('특수문자는 들어갈 수 없습니다.');
		 $("#subEmail1").val(temp.replace(re,"")); } 
	});
	$('#subEmail2').keyup(()=>{
		 var temp=$("#subEmail2").val();
		 if(re.test(temp)){ //특수문자가 포함되면 삭제하여 값으로 다시셋팅
			window.alert('특수문자는 들어갈 수 없습니다.');
		 $("#subEmail2").val(temp.replace(re,"")); } 
	});
	// 비밀번호 일치 여부 확인 
	$('#repwd').keyup(()=>{
		let password = $('#password').val();
		let repwd = $('#repwd').val();
		if(password != repwd ) {
			$('#repwd').css({'border':'1px solid red'});
			$('#password_equal').text('불일치');
			$('#password_equal').css({'color':'red'});
		}
		if(password == repwd ){
			$('#repwd').css({'border':'1px solid green'});
			$('#password_equal').text('일치');
			$('#password_equal').css({'color':'green'});
			
		}
	});
	// 팝업 창 닫기
	function closeSchPop() {
		$('.findSch').removeClass('display');
	    $('.findSch').addClass('nodisplay');
	    $('body').removeClass('hiden');
	}
	// 팝업 창 열기 
	function viewSchPop() {
		$('.findSch').removeClass('nodisplay');
		$('.findSch').addClass('display');
		var maxheight = $(window).height();
		$('.findSch').css({'height':maxheight});
		$('body').addClass('hiden');
		$('html,body').scrollTop(0);
	} 
	// 학교 검색하기 
	function searchSchool() {
		var schInput = $("#popupSchInput").val();
		var maxLength = 2;
		var schl_nm = $("#schl_name").val();														
		
		if(schl_nm == 'NEED'){
		   alert("학교급을 선택한 후 검색해 주세요.");
		   return;
		}
		if(schInput.length < maxLength){
			   alert("최소 2자리 이상 입력해주세요.");
			   return;
			}
	    if(schInput == '학교'){
		   alert("'" + schInput + "'로는 검색이 불가능 합니다."); 
		   return;
		}
	    var searchSchool = encodeURIComponent(schInput);

		//var searchSchool = "삼성초등학교";
		$.ajax({
					type : 'POST',
					url : "/studentCntl/searchSchool",
					data : {
						"searchSchool" : searchSchool,
						"schl_nm" : schl_nm
					},
					success : function(
							result) {
						$(
								"#searchResult")
								.html(
										result);
					},
					error : function(request,status,error) {
						
					}
				});
	}

	function btnSearchSet(schoolLocation,schoolGrade,schoolCd,schoolNm) {
		document.frmInsert.ex_region.value = schoolLocation;
		document.frmInsert.ex_schgrade.value = schoolGrade;
		document.frmInsert.ex_schl_cd.value = schoolCd;
		document.frmInsert.ex_schl_nm.value = schoolNm;
		//alert(document.frmInsert.ex_schl_cd.value + " " + document.frmInsert.ex_schl_nm.value);
		layerPop.close();

		var tempSchoolGrade = $("#ex_sclyy").val();
		if (schoolGrade == "초등학교" || schoolGrade.indexOf("(초)") > 0) {
			$("#ex_sclyy option").remove();
			<%-- foreach 1 to 6 --%>
			<c:forEach var="value" begin="1" end="6" >
			$("#ex_sclyy").append("<option value=\"<c:out value="${value}"/>\"><c:out value="${value}"/></option>");
			</c:forEach>
			
		} else {
			$("#ex_sclyy option").remove();
			<%-- foreach 1 to 6 --%>
			<c:forEach var="value" begin="1" end="3" >
			$("#ex_sclyy").append("<option value=\"<c:out value="${value}"/>\"><c:out value="${value}"/></option>");
			</c:forEach>
	}

	}
	</script>
</html>