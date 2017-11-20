<%@include file='menu_chofer_viajeActivo.jsp' %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row color-invoice">
		<div class="col-md-12">

			<div class="row">
				
				<div class="col-lg-5 col-md-5 col-sm-5">
                    <br>
					<h2>Log de viaje</h2>
					<h5>Id de log viaje: ${logViaje.id }</h5>
					<h5>Descripción: ${logViaje.tipoLogViaje }</h5>
					<h5>Precio: ${logViaje.precio}</h5>
				    <br> Inicio de act.: 21/04/2011 <br> Fecha : 02/11/2017
					
				</div>
			</div>
			<hr />
			<hr />
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
				   
					<a href="menu_chofer_viajeActivo" class="btn btn-success btn-sm">Volver al menú viaje activo</a>
				</div>
			</div>
			<hr>
			<div class="row"></div>
		</div>
	</div>
</div>

<%@include file='../../templates/Footer.jsp'%>           
 </div>