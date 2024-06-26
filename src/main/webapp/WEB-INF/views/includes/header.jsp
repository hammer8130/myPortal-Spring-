
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ page session="true"%>

<div id="header">
	<a:if test="${not empty errorMsg }">
		<h5>${errorMsg }</h5>
	</a:if>

	<h1>My Homepage</h1>
	<p>authUser : ${authUser }</p>
	<a:choose>
		<a:when test="${not empty authUser}">
			<ul>
				<li><a href="<a:url value="/users/logout" />">로그아웃</a></li>
				<li>${authUser.name}님,환영합니다.</li>
				<br>
				<!-- 로그인 한 사용자 -->
				<!-- 웰컴 메시지, 로그아웃 링크 -->
			</ul>
		</a:when>
		<a:otherwise>

				<li><a href="<a:url value="/users/join" />">회원가입</a></li>
				<li><a href="<a:url value="/users/login" />">로그인</a></li>
			</ul>
		</a:otherwise>
	</a:choose>

</div>
<!-- /header -->

