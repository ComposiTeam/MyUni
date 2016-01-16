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
	
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    
                    <c:choose>
                         
         				<c:when test="${!manager.isLogged()}">
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
	                    </c:when>
	                    
	                    <c:when test="${manager.isStudent()}">
	                  		<li>
		                        <a href="">Editar perfil</a>
		                    </li>
          		            <li>
		                        <a href="">Histórico</a>
		                    </li>
		                    <li>
		                        <a href="">Atualizar histórico</a>
		                    </li>
		                    <li>
		                    	<a class="dropdown-toggle" data-toggle="dropdown">
		                    		${manager.getUserLogged().getUsername() } <span class="caret"></span>
		                    	</a>
								<ul class="dropdown-menu">
								  <li><a href="logout">Logout</a></li>
								  <li><a href="#">Separated link</a></li>
								  <li role="separator" class="divider"></li>
								  <li><a href="#">Another</a></li>
								</ul>
		                    </li>  	
			            </c:when>
			            
		    	        <c:when test="${manager.isProfessor()}">
							<li>
		                        <a href="#register">Extrair os dados</a>
                    		    <li>Todos</li>
		                        <li>Campus</li>
		                        <li>Curso</li>
		                        <li>Disciplinas</li>
		                    </li>
		                    <li>
		                    	<a>${manager.getUserLogged().getUsername() }</a> 
		                    </li>
			            </c:when>
			            
		            </c:choose>
                </ul>
            </div>
                     
        <!-- closing second container -->
        </div>
    </nav>
    
	<div class="container">
