<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
       <div id="campus" class="col-md-4">
           <h1>Lista de Campus</h1>
               <ul class="list-group">
                   <c:forEach items="${campus}" var="camp">
                           <li class="list-group-item">
                           		<a value="${camp.id}" href="#" class="campus-link">${camp.code} - ${camp.name}</a></li>
                   </c:forEach>
               </ul>
       </div>
       <div id="institutes" class="col-md-4">
    </div>
    <div id="disciplines" class="col-md-4">
    </div>
</div>