<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de disciplinas</title>
	<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">
		
	<!-- jQuery -->
	<script src="<c:url value='/js/jquery.js'/>"></script>
	
	<!-- Bootstrap Core -->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container">
		<h1>Lista de Campus</h1>
		<table class="table table-striped">
			<tr>
				<th>Campus</th>
				<th>Institutos</th>
				<th>Disciplinas</th>
			<tr>
			<c:forEach items="${campus}" var="camp">
				<c:forEach items="${camp.institutes}" var="institute">
					<c:forEach items="${institute.disciplines}" var="discipline">
						<tr>
							<td>${camp.code} - ${camp.name}</td>
							<td>${institute.code} - ${institute.name}</td>
							<td>${discipline.code} - ${discipline.name}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
</body>
</html>
