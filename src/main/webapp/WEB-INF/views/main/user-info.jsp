<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h5>사용자 정보</h5>
	
	<div class="userInfo" style="margin: 30px;">
	<p>유저 아이디 : ${User.loginId}</p>
	<p>유저 이름 : ${ User.userName }</p>
	<p>유저 성별 : ${User.gender}</p>
	<p>유저 생일 : ${User.birthDate}</p>
	<p>유저 타입 : 
	
						<c:choose>
				
				<c:when test="${User.userType eq '1'}"> 관리자 </c:when>
				
				<c:when test="${User.userType eq '2'}"> 선생님 </c:when>
				
				<c:otherwise> 학생 </c:otherwise>
				
				</c:choose></p>

</div>