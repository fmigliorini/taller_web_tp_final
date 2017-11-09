
<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row color-invoice">
		<div class="col-md-12">

			<div class="row">
				<div class="col-lg-7 col-md-7 col-sm-7">
					<h1>Mudanzas Pepe</h1>
					<br /> <br /> <strong>Email : </strong> info@mudanzapepe.com <br />
					<strong>WEB : </strong> www.mudanzapepe.com.ar <br /> <strong>Telefono
						: </strong>011 4480-8900 <br /> <strong>Direccion : </strong>Florencio
					Varela 1903, B1754JEC San Justo, Buenos Aires
				</div>
				<div class="col-lg-5 col-md-5 col-sm-5">

					<h2>Log de viaje</h2>
					<h5>Id: ${logViaje.id }</h5>
					<h5>Descripción: ${logViaje.descripcion }</h5>
					<h5>Precio: ${logViaje.precio}</h5>
					<br> Inicio de act.: 21/04/2011 <br> Fecha : 02/11/2017
				</div>
			</div>
			<hr />
			<hr />
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
				   <!-- No me anda el volver al inicio -->
					<a href="index_chofer" class="btn btn-success btn-sm">Volver al inicio</a>
				</div>
			</div>
			<hr>
			<div class="row"></div>
		</div>
	</div>
</div>

<%@include file='../../templates/Footer.jsp'%>            </div>