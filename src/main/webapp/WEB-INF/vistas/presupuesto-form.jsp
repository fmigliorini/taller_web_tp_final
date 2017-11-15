<%@include file='../../templates/Header.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<h1> Formulario presupuesto </h1>
    <form action="generarPresupuesto">
    	<input type="hidden" id="idCliente" name="idCliente" value="${idCliente}">
	    <div class="form-row">
	        <div class="form-group col-md-12">
	            <label for="tipoVehiculo">Tipo Vehiculo</label>
	            <select id="tipoVehiculo" name="tipoVehiculo" class="form-control">
	                <option selected>Seleccione una opción</option>
	                <c:forEach items="${tiposVehiculos}" var="tv">
	                	<option value="${tv.id}">${tv.descripcion}</option>
	                </c:forEach>
	            </select>
	        </div>
	    </div>
	    <div class="form-row">
		    <div class="form-group col-md-6">
		        <label for="origen">Origen</label>
		        <input type="text" required="required" class="form-control" id="origen" name="origen" placeholder="Calle Falsa, Ramos Mejias, La Matanza, Buenos Aires">
		    </div>
		    <div class="form-group col-md-6">
		        <label for="destino">Destino</label>
		        <input type="text" required="required" class="form-control" id="destino" name="destino" placeholder="Calle Verdadera, Isidro Casanova, La Matanza, Buenos Aires">
		    </div>
	    </div>
	    <div class="form-row">	
	        <div class="form-group col-md-6">
	            <label for="fecha">Fecha</label>
	            <input type="date" required="required" class="form-control" id="fecha" name="fecha">
	        </div>
	        <div class="form-group col-md-6">
	            <label for="hora">Hora</label>
	            <input type="time" required="required" class="form-control" id="hora" name="hora">
	        </div>
        </div>
	    <div class="form-row">	
	        <div class="form-group col-md-12">
	            <label for="kilometros">Kilometros</label>
	            <input type="text" required="required" class="form-control" id="kilometros" name="kilometros" readonly>
	        </div>
		    <div class="form-group col-md-12">
		        <label for="descripcion">Descripción </label>
		        <textarea required="required" class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
		    </div>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Generar Presupuesto">
   	    <button type="submit" class="btn btn-danger">Cancelar</button>
	    
	</form>
</div>

<%@include file='../../templates/Footer.jsp' %>
