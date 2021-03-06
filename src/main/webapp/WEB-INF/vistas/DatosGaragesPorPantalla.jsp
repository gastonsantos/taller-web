<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="layout/layout::head">
    <meta charset="UTF-8">
</head>
<body>
    

<ul>
<c:forEach items="${garages}" var="garage">
<li>${garage.nombre}, ${garage.id},${garage.localidad},${garage.precioHora} </li>
</c:forEach>
</ul>
<h1>Listado de Garges</h1>
<h5><a href="formularioAgregarGarage">Agregar Garage</a></h5>  
        <table border="1">
            <tr>
                <th style="width:  50px;">Id</th>
                <th style="width: 250px;">Nombre</th>
                <th style="width: 150px;">Localidad</th>
                <th style="width: 150px;">Calle</th>
                <th style="width: 150px;">Numero</th>
                <th style="width: 150px;">Precio Hora $$</th>
                <th style="width: 150px;">Precio Estadia $$</th>
                <th style="width: 150px;">Precio Mes $$</th>
                <th style="width: 150px;">Autos En Garage</th>
            </tr>
            <c:forEach var="garage" 
                       items="${garages}"
                       varStatus="status">
                <tr>
                    <td><b>${garage.id}</b></td>
                    <td>${garage.nombre}</td>
                    <td>${garage.localidad}</td>
                    <td>${garage.calle}</td>
                    <td>${garage.numero}</td>
                    <td>${garage.precioHora}</td>
                    <td>${garage.precioEstadia}</td>
                    <td>${garage.precioMes}</td>
                    <td> ${garage.contador} </td>
   					<td> <a href="${pageContext.request.contextPath}/lista/eliminar/${garage.id}">Eliminar Garage</a> </td>
   					<td> <a href="${pageContext.request.contextPath}/mostrarAutosDeUnGarage/${garage.id}">Mostrar Autos de Garage</a> </td>
   					<td> <a href="${pageContext.request.contextPath}/mostrarGarage/${garage.id}">Agregar Auto</a> </td>
                </tr>
            </c:forEach>

    <footer th:replace="layout/layout::footer" class="bg-dark"></footer>
</body>
</html>