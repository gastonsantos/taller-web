<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billetera</title>
</head>
<body>

<form action="realizarPago" method="GET">
<div>
<h2>Fecha</h2>
<input type="date" name="fecha"><br>


<h2>Hora</h2>
</div>
<input type="time" name="hora">

<button type="submit" >calcular</button><br>
</form>

<c:if test="${not empty pagarMonto}">
	<h4><span>${error}</span></h4>
	<h1>El Monto a Pagar ${resultado}</h1>
	<br>
</c:if>

</body>
</html>