<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<table>
		<tr>
			<td>Histórico</td>
		</tr>
		<tr>
			<td>${transcript.id}</td>
		</tr>
		<tr>
			<td>${transcript.student.mwId}</td>
			<td>${transcript.student.name}</td>
		</tr>
		<c:forEach items="${transcript.disciplineResults}" var="disciplineResults" >
			<tr>
				<td>${disciplineResults.course.discipline.name}</td>
				<td>${disciplineResults.mention.abreviation}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>