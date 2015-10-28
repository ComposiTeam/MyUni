<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrado de Disciplina</title>
</head>
<body>
	<h2>Cadastro de Disciplina</h2>
	<form action="discipline" method="POST">
	<table>
		<tr>
			<td><label for="username-text">Código: </label></td>
			<td><input id="code" class="register-field" type="text" name="discipline.code"  /></td>
		</tr>
		<tr>
			<td><label for="username-text">Nome: </label></td>
			<td><input id="name" class="register-field" type="text" name="discipline.name"  /></td>
		</tr>
		<tr>
			<td><label for="username-text">Créditos: </label></td>
			<td><input id="nrCredits" class="register-field" type="text" name="discipline.NumberOfCredits"  /></td>
		</tr>
		<tr>
			<td><input id="submit" type="submit" value="Salvar" /></td>
			<td><input id="clean" type="button" value="Limpar" /></td>
		</tr>
	</table>
	</form>
</body>
</html>