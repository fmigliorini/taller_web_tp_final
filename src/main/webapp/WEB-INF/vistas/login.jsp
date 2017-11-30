<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file='../../templates/Header_web.jsp' %>

		<div class="container">
			<div id="" style="margin-top:50px;" class="mainbox col-md-6 offset-md-3 col-sm-8 offset-sm-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				
				<form:form action="validar-login" method="POST" modelAttribute="usuario">
			    	<h3 class="form-signin-heading">Ingresar</h3>
			    	<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
					<hr class="colorgraph"><br>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<label>Email</label>
					<form:input path="email" id="email" type="email" class="form-control" />
					<label>Contraseña</label>
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					<br>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>
				</form:form>

				
		        
				<a class="nav-link" href="cliente-form">¿Aun no posees una cuenta?</a>
		        
			</div>
		</div>
		
<%@include file='../../templates/Footer.jsp' %>