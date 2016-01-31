<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transcript by program</title>
</head>
<body>
	<table id="transcript" >
	<c:forEach var="i" begin="1" end="${maxSemester}">
		<tr>
			<td>${i}</td>
			<td>
			<c:forEach items="${disciplines}" var="discipline">
				<c:if test="${discipline.getSemester() eq i }" >
					<div>
					${discipline.getDisciplineCode()}
					${discipline.getDisciplineName()}
					${discipline.getDisciplineCredits()}
					${discipline.isApproved() }
					</div>
				</c:if>
			</c:forEach>
			</td>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>