<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Programa</title>
<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">

<!-- jQuery -->
<script src="<c:url value='/js/jquery.js'/>"></script>

<!-- Bootstrap Core -->
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
</head>
<body>
	<%@ include file="../professor/navbar-logged.jsp"%>
	<div class="jumbotron" id="jumbotron-default">
		<div class="row page-header">
			<div class="col-lg-12 text-center">
				<h1>Cadastro de Programa</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form action="save" method="POST">
					<input class="form-control" type="text" name="program.name"
						id="nameProgram" required="required"
						placeholder="Escolha um nome do programa" />
						<br />
						<input class="btn btn-success btn-group-justified"
						type="submit" id="register-button" value="Registrar" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
