<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
    <c:when test="${not empty programs}">
        <h1>Lista de Programas</h1>
        <ul class="list-group">
            <c:forEach items="${programs}" var="program">
                    <li class="list-group-item"><a value="${program.id}" class="programs-link" href="#" >${program.name}</a></li>
            </c:forEach> 
        </ul>    
    </c:when>    
    <c:otherwise>
        Something went wrong
    </c:otherwise>
</c:choose>