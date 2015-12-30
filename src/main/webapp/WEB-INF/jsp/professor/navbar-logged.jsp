<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body id="page-top" class="welcome">

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

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                     <li class="page-scroll">
                        <a href="#mural">Mural</a>
                    </li>
                    <li class="page-scroll">
                    	<a href="feedbacks">Feedbacks</a>
                    </li>
                    <li class="page-scroll">
                    	<a href="settings">Conta</a>
                    </li>
                    <li class="page-scroll">
                    	<a href="<c:url value='program/save'/>">Programa</a>
                    </li>
                    <li class="page-scroll">
                    	<div class="logged-info">${manager.getUserLogged().getUsername() } | 
						<form action="logout">
						<input type="submit" value="Sair"/>
						</form>
						
                    	</div>

                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
