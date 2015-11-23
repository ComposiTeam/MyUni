<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Gradplanner</title>
	<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">
		
	<!-- jQuery -->
	<script src="<c:url value='/js/jquery.js'/>"></script>
	
	<!-- Bootstrap Core -->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
</head>
 <body>
  <%@ include file="navbar.jsp" %>
  	<div class="container error-box">
	  	<ul class="list-group">
		  	<c:forEach var="error" items="${errors}">
		    	<li class="list-group-item">${error.message}</li>
			</c:forEach>
		</ul>
  	</div>
	<div class="title">
		<img src="images/gradplanner.png" alt="GradPlanner">
	</div>
		<div class="jumbotron jumbotron-default">
	  	<div class="container">
	  		<h1>Bem vindo ao GradPlanner!</h1>
	  		<p>Uma rede social para alunos de graduação da  FGA - Universidade de Brasília , aonde é possível compartilhar experiências e ao mesmo tempo incrementar o aproveitamento de seu curso.</p>
  	</div>
  </div>
  <div class="jumbotron" id="jumbotron-default">
        <div class="row page-header">
            <div class="col-lg-12 text-center">
                <h1>Cadastro</h1>
            </div>
        </div>
        <div class="row">
	        <div class="col-md-4 col-md-offset-4">
	        	<form action="register" method="POST">
					<input class="form-control" type="text" name="user.username" id="username" 
						required="required" placeholder="Escolha um nome de usuário"/>
					<br/>
					<input class="form-control" type="password" name="user.password" id="password"
						required="required" placeholder="Escolha uma senha"/>
					<br/>
					<input class="form-control" type="email" name="user.email" id="email" 
						required="required" placeholder="Entre com o email"/>
					<br/>
					<span class="input-group-addon">
						<input class="form-control" type="checkbox" name="termsOfService" value="terms">
						Concordo com os termos de serviço.
					</span>
					<br/>
					<input class="btn btn-success btn-group-justified" type="submit" id="register-button" value="Registrar" />
				</form>
	        </div>
	    </div>
  </div>
</body>
</html>
