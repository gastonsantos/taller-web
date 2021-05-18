<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculadora</title>
</head>
<body>
<h2>Calculadora</h2><br>
<form action="realizaroperacion" method="GET">
<div>
Operando 1 
<input type="number" name="operando1">
</div>
<div>
Operando 2
<input type="number" name="operando2">
</div>
<h1>Elija una operacion</h1>

<input type="radio" name="operacion" value="1">SUMA
<br>
<input type="radio" name="operacion" value="2">RESTA
<br>
<input type="radio" name="operacion" value="3">MULTIPLICACION
<br>
<input type="radio" name="operacion" value="4">DIVISION
<br>
<button type="submit" class="btn btn-default">calcular</button><br>
</form>
<c:if test="${not empty resultado}">
	<h4><span>${error}</span></h4>
	<h1>El resultado de ${operacion} ${operando1} y el ${operando2} es ${resultado}</h1>
	<br>
</c:if>	



</body>
</html>