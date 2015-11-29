<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
    <c:when test="${not empty disciplines}">
        <h1>Lista de Disciplinas</h1>
        <ul class="list-group">
            <c:forEach items="${disciplines}" var="discipline">
                    <li class="list-group-item"><a value="${discipline.id}" href="#" class="discipline-link">${discipline.code} - ${discipline.name}</a></li>
            </c:forEach> 
        </ul>    
    </c:when>    
    <c:otherwise>
        ${error} 
    </c:otherwise>
</c:choose>
