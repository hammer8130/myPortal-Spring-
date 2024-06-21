<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
<link type="text/css" rel="stylesheet"
	href="<x:url value="/css/home.css" />"/>
<!-- href="<c:url value="/css/home.css" />"/> -->
</head>
<body>
	<div id="container">

		<!-- Header Include -->
		<x:import url="/WEB-INF/views/includes/header.jsp">
			<x:param name="param1" value="value1"></x:param>
			<x:param name="param2" value="value2"></x:param>
		</x:import>

		<%--  
    <jsp:include page="/WEB-INF/views/includes/header.jsp">
    	<jsp:param value="value1" name="param1"/>
    	<jsp:param value="value2" name="param2"/>
    </jsp:include> --%>

		<!-- Navigation Include -->
		<x:import url="/WEB-INF/views/includes/navigation.jsp" />

		<%-- <jsp:include page="/WEB-INF/views/includes/navigation.jsp">
		<jsp:param value="value1" name="param1"/>
		<jsp:param value="value2" name="param2"/>
	</jsp:include> --%>
		<div id="wrapper">
			<div id="content"></div>
		</div>


		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>