<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="layout/layout::head">
    <meta charset="UTF-8">
</head>
<body>
    
<h1>Garges Seleccionado</h1>

<h5> ${garage.nombre} </h5>
<h5> ${garage.localidad }</h5>
<h5> ${garage.calle }</h5>
<h5> ${garage.numero }</h5>
<h5> ${garage.precioHora }</h5>
<h5> ${garage.precioEstadia }</h5>
<h5> ${garage.precioMes }</h5>
<h5> ${garage.capacidad }</h5>

<main class="container"> <!-- Clase de Bootstrap. Hace que los elementos no lleguen hasta el borde -->
			<form:form  action="${pageContext.request.contextPath}/agregarAutoAGarage/${garage.id}" method="POST" modelAttribute="auto" class="row g-3">
			<h1 class="mt-3">Agregar Auto</h1>
				<div class="col-md-6">			
		    <label for="patente" class="form-label control-label">Patente</label>
		    <form:input type="text" class="form-control" id="patente" path="patente"/>
		 
		  </div>
		  
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary control-label mb-3">Asignar</button>
		  </div>
  		</form:form>



</body>
</html>