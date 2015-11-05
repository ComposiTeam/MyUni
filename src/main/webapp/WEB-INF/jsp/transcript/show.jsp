<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Histórico do Aluno</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2">Histórico</td>
		</tr>
		<tr>
			<td colspan="2">Dados do Aluno</td>
		</tr>
		<tr>
			<td>${transcript.student.name}</td>
			<td>${transcript.student.mwId}</td>
		</tr>
		<tr>
			<td colspan="2">Disciplinas</td>
		</tr>
		<tr>
			<td >Disciplina</td>
			<td>Mencão</td>
		</tr>
		<c:forEach items="${transcript.disciplineResults}" var="results" >
			<tr>
				<td>${results.course.discipline.name}</td>
				<td>${results.mention.abreviation}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
