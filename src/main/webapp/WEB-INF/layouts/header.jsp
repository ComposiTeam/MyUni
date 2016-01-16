<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Gradplanner</title>
		
		<!-- Global stylesheet -->
		<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">
		
		<!-- jQuery -->
		<script src="<c:url value='/js/jquery-2.2.0.js'/>"></script>
		
		<!-- Bootstrap Core -->
		<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
	</head>
<body>
<div class="container">
	<!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">GradPlanner</a>
            </div>
			
            <c:choose>
				<!-- Without logged user -->
            	<c:when test="${!manager.isLogged()}">
		            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                <ul class="nav navbar-nav navbar-right">
		                    <li class="hidden">
		                        <a href="#page-top"></a>
		                    </li>
		                    <li class="page-scroll">
		                        <a href="#register">Registre-se</a>
		                    </li>
		                    <li>
			                    <div class="form-group row login-form">
			                    	<form name="login-form" action="login" method="POST">
				                    	<div class="col-md-4">
					                        <input class="form-control" type="text" name="user.username" 
					                        	required="required" id="username-inputType" placeholder="Username"/>
				                        </div>
				                        <div class="col-md-4">
				                        <input class="form-control" name="user.password" type="password" 
				                        	required="required" id="password-inputType" placeholder="Password"/>
				                        </div>
				                        <div class="col-md-2">
				                        	<input class="form-control" type="submit" id="login-inputButton" value="Login"/>
				                        </div>
			                    	</form>
			                    </div>
		                    </li>
		                </ul>
		            </div>
            	</c:when>
            	

	            <!-- Student logged -->
	           	<c:when test="${manager.isStudent()}">
		            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                <ul class="nav navbar-nav navbar-right">
		                    <li class="hidden">
		                        <a href="#page-top"></a>
		                    </li>
		                    <li class="page-scroll">
		                        <a href="#register">Editar perfil</a>
		                    </li>
          		            <li class="page-scroll">
		                        <a href="#register">Histórico</a>
		                    </li>
		                    <li class="page-scroll">
		                        <a href="#register">Atualizar histórico</a>
		                    </li>
		                    <li class="page-scroll">
		                    	<a class="dropdown-toggle" data-toggle="dropdown">
		                    		${manager.getUserLogged().getUsername() } <span class="caret"></span>
		                    	</a>
								<ul class="dropdown-menu">
								  <li><a href="#">Action</a></li>
								  <li><a href="#">Another action</a></li>
								  <li><a href="#">Something else here</a></li>
								  <li role="separator" class="divider"></li>
								  <li><a href="#">Separated link</a></li>
								  <li role="separator" class="divider"></li>
								  <li><a href="#">One more separated link</a></li>
								</ul>
		                    </li>
		                </ul>
		            </div>
	            </c:when>
	            
            	<!-- Student logged -->
    	        <c:when test="${manager.professor()}">
	                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                <ul class="nav navbar-nav navbar-right">
		                    <li class="hidden">
		                        <a href="#page-top"></a>
		                    </li>
		                    <li class="page-scroll">
		                        <a href="#register">Extrair os dados</a>
                    		    <li>Todos</li>
		                        <li>Campus</li>
		                        <li>Curso</li>
		                        <li>Disciplinas</li>
		                    </li>
		                    <li class="page-scroll">
		                    	<a>${manager.getUserLogged().getUsername() }</a> 
		                    </li>
		                </ul>
		            </div>
	            </c:when>
            </c:choose>
        <!-- closing second container -->
        </div>
    </nav>
