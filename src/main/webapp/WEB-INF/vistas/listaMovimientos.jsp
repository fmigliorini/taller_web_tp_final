<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Lista de ${movimiento.tipomovimiento.descripcion}</h1>
	<form action="generarPresupuesto">

		<div class="container">

			<hr>
			<div class="row">
				<div class="col-xs-12" style="">
					<div class="panel panel-default list-group-panel">
						<div class="panel-body">
							<ul class="list-group list-group-header">
								<li class="list-group-item list-group-body">
									<div class="row">
										<div class="col-xs-4 text-left">Numero del comprobante</div>
										<div class="col-xs-2">Fecha</div>
										<div class="col-xs-3">$Precio</div>
										<div class="col-xs-3">Vista previa</div>
									</div>
								</li>
							</ul>
							<c:forEach items="${listaMovimientos}" var="mov">
								<ul class="list-group list-group-body" style="">
									<li class="list-group-item">
										<div class="row">
											<div class="col-xs-4 text-left" style="">
												<a><span class="glyphicon glyphicon-file"
													aria-hidden="true"></span>${mov.letra} ${mov.puntoventa} -
													${mov.numero}</a>
											</div>
											<div class="col-xs-2" style="">${mov.fecha}</div>
											<div class="col-xs-3" style="">${mov.viaje.precio}</div>
											<div class="col-xs-3" style="">
												<a href="#" class="btn btn-primary a-btn-slide-text"> <span
													class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
													<span><strong>Ver</strong></span>
												</a>
											</div>
										</div>
									</li>
								</ul>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>

	</form>
</div>

<%@include file='../../templates/Footer.jsp'%>