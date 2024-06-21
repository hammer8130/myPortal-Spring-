
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ page session="true"%>

<div id="header">
	<h1>My Homepage</h1>
	<p>authUser : ${authUser }</p>
	<a:choose>
		<a:when test="${not empty authUser}">
			<ul>
				<li><a href="<c:url value="/users?a=logout" />">로그아웃</a></li>
				<li>${authUser.name}님,환영합니다.</li>
				<br>
				<!-- 로그인 한 사용자 -->
				<!-- 웰컴 메시지, 로그아웃 링크 -->
			</ul>
		</a:when>
		<a:otherwise>

			<ul>
				<!-- 로그인 안한 사용자 -->
				<!-- 가입링크, 로그인 폼 링크 
				<li><a href="<%=request.getContextPath()%>/users?a=joinform">회원가입
						링크</a></li>
				<li><a href="<%=request.getContextPath()%>/users?a=loginform">로그인</a></li>
				-->
				
				<li><a href="<a:url value="/users?a=joinform" />">회원가입</a></li>
				<li><a href="<a:url value="/users?a=loginform" />">로그인</a></li>
			</ul>
		</a:otherwise>
	</a:choose>

</div>
<!-- /header -->

