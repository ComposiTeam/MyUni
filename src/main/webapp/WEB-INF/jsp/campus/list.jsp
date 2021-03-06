<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Campus</title>
	<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">
		
	<!-- jQuery -->
	<script src="<c:url value='/js/jquery-1.10.2.js'/>"></script>
	
	<!-- Bootstrap Core -->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/searchinstitutes.js'/>"></script>
	
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/index/navbar.jsp" %>
	<div class="container content">
        <div id="campus" class="col-md-4">
            <h1>Lista de Campus</h1>
                <ul class="list-group">
                    <c:forEach items="${campus}" var="camp">
                            <li class="list-group-item"><a value="${camp.id}" href="#" class="campus-link">${camp.code} - ${camp.name}</a></li>
                    </c:forEach>
                </ul>
        </div>
        <div id="institutes" class="col-md-4">
	    </div>
	    <div id="disciplines" class="col-md-4">
	    </div>
	</div>
	</body>
</html>
