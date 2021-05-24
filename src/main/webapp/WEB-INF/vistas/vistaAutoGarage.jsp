<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Garages para elegir</title>
</head>
<body>
<h1>Garages para elegir</h1>
<ul>
<c:forEach items="${garages}" var="garage">
<li>${garage.nombre}, ${garage.id},${garage.localidad},${garage.precioHora} </li>
</c:forEach>
</ul>
 </body>
</html>