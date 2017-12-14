<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file='../../templates/Header_web.jsp' %>

		<div class="container" style="margin-top:50px;">
		
		
			<div id="tabs-home" class="row">

	<div class="row col-md-1"></div>

		<div class="row col-md-10">
			<div class="col-md-10 one-column-text">
					    	<h3 class="form-signin-heading">Registrate y sumate a los beneficios.</h3>
			    	<%--Bloque que es visible si el elemento error no está vacío	--%>
					<hr class="colorgraph"><br>
				<h4">Para poder cotizar una mudanza necesita tener una cuenta con nosotros. Los beneficios de tener una cuenta es que usted podra generar varios presupuestos , facturas y podra verlos desde su perfil</h4>
			</div>
			
		</div>

	<div class="row col-md-10 one-column-text">
	    	<h3 class="form-signin-heading">Ingresar</h3>
			    	<%--Bloque que es visible si el elemento error no está vacío	--%>
					<hr class="colorgraph"><br></div>
<div  class="col-md-3"></div>
			<div  class="col-md-6">
			
				<form:form action="validar-login" method="POST" modelAttribute="usuario">


					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<label>Email</label>
					<form:input path="email" id="email" type="email" class="form-control" />
					<label>Contrase�a</label>
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					<br>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>
				</form:form>

				
		        
				<a class="nav-link" href="cliente-form">�Aun no posees una cuenta?</a>
		        
			</div>
		</div>
			</div>
		
<%@include file='../../templates/Footer.jsp' %>