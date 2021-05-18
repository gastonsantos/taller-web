<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
		<meta charset="ISO-8859-1">
		<title>Registro De Usuario</title>
</head>
<body>

	<body>
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				<form:form action="ConfirmarRegistro" method="POST" modelAttribute="usuario">
			    	<h3 class="form-signin-heading">Garage</h3>
					<hr class="colorgraph"><br>

					
					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<form:input path="nombre" id="nombre" name="nombre" type="text" class="form-control"/><p>NOMBRE</p>
					<form:input path="apellido" id="apellido" name="apellido" type="text" class="form-control"/><p>APELLIDO</p>
					<form:input path="rol" id="rol" name="rol" type="text" class="form-control"/><p>ROL</p>
					<form:input path="email" id="email" name="email" type="email" class="form-control" /><p>INGRESA UN MAIL</p>
					<form:input path="password" type="password" name="password" id="password" class="form-control"/><p>Ingresa CONTRASEÑA</p>     		  
						<input type="password" name="repassword" id="repassword" class ="form-control"><p>Reingresar Contraseña</p>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Registrarse</button>
				</form:form>

				<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
		        
		        <p class="text-center">
		        	Confirmaiyon my friend<a href="">Confirmar Datos</a>
		        
		        </p>
		        <p class="text-center">
		        <a href="">Cambiar TODO</a>
		        </p>
		        
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
	
		

</body>
</html>