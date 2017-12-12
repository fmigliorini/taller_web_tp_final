<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<h1>Generar presupuesto para nuevo viaje.</h1>
	<form:form id="formPre" action="generarPresupuesto" method="POST"
		modelAttribute="viaje">
		<c:if test="${ !empty error }">
			<h2 style="color: red;">${error }</h2>
		</c:if>
		<input type="hidden" id="idCliente" name="idCliente"
			value="${idCliente}">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="origen">Origen</label>
				<form:input type="text" required="required" class="form-control"
					id="origen" path="origen"
					placeholder="Calle altura, Localidad, Provincia, Pais" />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="destino">Destino</label>
				<form:input type="text" required="required" class="form-control"
					id="destino" path="destino"
					placeholder="Calle altura, Localidad, Provincia, Pais" />
			</div>

			<div class="form-group col-md-6">
				<label for="hora">Fecha y Hora de partida</label> <input
					type="datetime-local" required="required" class="form-control"
					id="fechaHoraInicio" name="fechaHoraInicio"
					pattern="dd/MM/yyyy HH:mm:ss" />
			</div>
		</div>

		<div class="form-row">

			<div class="form-group col-md-6">
				<label for="hora">Duracion</label> <input type="text"
					required="required" class="form-control" id="duracion" />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-12">
				<label for="kilometros">Kilometros</label>
				<form:input type="number" required="required" class="form-control"
					id="kilometros" path="kilometros" readonly="readonly" min="1" />
			</div>
			<div class="form-group col-md-12">
				<label for="descripcion">Peso </label>
				<form:input type="number" required="required" class="form-control "
					id="peso" path="peso" rows="3" min="0" readonly="readonly" />
			</div>
			<div class="form-group col-md-12">
				<label for="descripcion">Observacion </label>
				<form:input type="text" required="required" class="form-control"
					id="descripcion" path="descripcion" />
			</div>
		</div>

		<input type="number" class="hidden" name="duracionInt"
			id="duracionInt" />
		<input type="submit" class="btn btn-primary"
			value="Generar Presupuesto">
		<button type="submit" class="btn btn-danger">Cancelar</button>

	</form:form>
</div>

<%@include file='../../templates/Footer.jsp'%>

<script>
	$("#kilometros").keydown(function(evt) {
		evt.preventDefault();
	});
</script>