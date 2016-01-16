<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<p>Uma rede social para alunos de graduação da FGA - Universidade
			de Brasília , aonde é possível compartilhar experiências e ao mesmo
			tempo incrementar o aproveitamento de seu curso.</p>
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
				<input class="form-control" type="text" name="user.username"
					id="username" required="required"
					placeholder="Escolha um nome de usuário" /> <br /> <input
					class="form-control" type="password" name="user.password"
					id="password" required="required" placeholder="Escolha uma senha" />
				<br /> <input class="form-control" type="email" name="user.email"
					id="email" required="required" placeholder="Entre com o email" />
				<br /> 
				<span class="input-group-addon">
					<label>Eu sou </label> 
					<label class="radio-inline"> 
						<input type="radio" name="optradio" value="Students">Studante
					</label> 
					<label class="radio-inline"> 
						<input type="radio"	name="optradio" value="Professor">Professor
					</label>
				</span>
				<br/>
				<div class="text-center">
		        	<input type="checkbox">
			        <br/>
			        Concordo com os termos de serviço.
			    </div>
				<br/>
					<input class="btn btn-success btn-group-justified"
						type="submit" id="register-button" value="Registrar" />
			</form>
		</div>
	</div>
</div>