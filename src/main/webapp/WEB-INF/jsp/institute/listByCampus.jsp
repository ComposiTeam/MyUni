<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
    <c:when test="${not empty institutes}">
        <h1>Lista de Institutos</h1>
        <ul class="list-group">
            <c:forEach items="${institutes}" var="institute">
                    <li class="list-group-item"><a value="${institute.id}" class="institutes-link" href="#" >${institute.code} - ${institute.name}</a></li>
            </c:forEach> 
        </ul>    
    </c:when>    
    <c:otherwise>
        Something went wrong
    </c:otherwise>
</c:choose>
