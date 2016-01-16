<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Escolher curso</title>
</head>
<body>
	<form action="chProgram" method="post">
	<label>Curso: </label>
	<select name="idProgram" id="programs" >
		 
			<c:forEach items="${programs}" var="program">
				<option value="${program.id}">${program.name}</option>
			</c:forEach>
	</select>
	<input type="submit" value="Enviar">
	</form>
</body>
</html>