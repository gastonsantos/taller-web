<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Elegir un Garage</title>
</head>
<body>
	<div class="container mt-3">
		<table class="table table-hover">
	
	  <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Calle</th>
	      <th scope="col">Localidad</th>
	      <th scope="col">Precio por Hora</th>
	       <th scope="col">Precio por Mes</th>
	       <th scope="col">Precio por Estadia</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="garage" 
	             items="${garages}"
	             varStatus="status">
	                <tr>
	                    <td><b>${garage.id}</b></td>
	                    <td>${garage.nombre}</td>
	                    <td>${garage.localidad}</td>
	                    <td>${garage.precioHora}</td>
	                    <td>${garage.precioMes}</td>
	                    <td>${garage.precioEstadia}</td>
						<td><a class="btn btn-primary mt-2" href="homeGarages" role="button">Elegir garage</a></td>
	                </tr>
	                
	            </c:forEach>
	  </tbody>
	</table>
		</div>
</body>
</html>