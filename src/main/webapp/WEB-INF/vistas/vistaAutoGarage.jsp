<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="layout/layout::head">
<meta charset="UTF-8">
</head>
<body>



	<h1>Listado de Garages</h1>

	<select name="select">





		<option value="garage">Garage1</option>
		<option value="garage">Garage2</option>
	</select>
	<button type="submit" class="btn btn-primary control-label mb-3">Elegir</button>





	<footer th:replace="layout/layout::footer" class="bg-dark"></footer>
</body>
</html>