<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Histórico do aluno</title>
	<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">
		
	<!-- jQuery -->
	<script src="<c:url value='/js/jquery.js'/>"></script>
	
	<!-- Bootstrap Core -->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
</head>
<body>
	<%@ include file="/WEB-INF/layouts/navbar-logged.jspf" %>
	<div class="container content">
	
		<h1>Histórico</h1>
		<ul class="list-group">
			<li class="list-group-item">
				Dados do Aluno - ${transcript.student.name}
			</li>
			<li class="list-group-item">	
				Matricula - ${transcript.student.mwId}
			</li>
		</ul>
		<div class="panel panel-default">
			<div class="panel-heading">Disciplinas cursadas</div>		
			<table class="table">
				<tr>
					<td >Disciplina</td>
					<td>Mencão</td>
				</tr>
				<c:forEach items="${transcript.results}" var="results" >
					<tr>
						<td>${results.course.discipline.name}</td>
						<td>${results.mention.abreviation}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
