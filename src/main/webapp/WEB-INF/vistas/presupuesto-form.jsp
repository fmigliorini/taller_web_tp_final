<%@include file='../../templates/Header.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<h1> Formulario presupuesto </h1>
    <form action="generarPresupuesto">
	    <div class="form-row">
	        <div class="form-group col-md-6">
	            <label for="idCliente">Cliente</label>
	            <select id="idCliente" name="idCliente" class="form-control">
	                <option selected>Seleccione una opci�n</option>
					<c:forEach items="${clientes}" var="c" >
						<option value="${c.id}">${c.nombre}</option>
					</c:forEach>
	            </select>
	        </div>
	        <div class="form-group col-md-6">
	            <label for="tipoVehiculo">Tipo Vehiculo</label>
	            <select id="tipoVehiculo" name="tipoVehiculo" class="form-control">
	                <option selected>Seleccione una opci�n</option>
	                <c:forEach items="${tiposVehiculos}" var="tv">
	                	<option value="${tv.id}">${tv.descripcion}</option>
	                </c:forEach>
	            </select>
	        </div>
	    </div>
	    <div class="form-group">
	        <label for="origen">Origen</label>
	        <input type="text" required="required" class="form-control" id="origen" name="origen" placeholder="Calle Falsa, Ramos Mejias, La Matanza, Buenos Aires">
	    </div>
	    <div class="form-group">
	        <label for="destino">Destino</label>
	        <input type="text" required="required" class="form-control" id="destino" name="destino" placeholder="Calle Verdadera, Isidro Casanova, La Matanza, Buenos Aires">
	    </div>
        <div class="form-group">
            <label for="kilometros">Kilometros</label>
            <input type="text" required="required" class="form-control" id="kilometros" name="kilometros">
        </div>
	    <div class="form-group">
	        <label for="descripcion">Descripci�n </label>
	        <textarea required="required" class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Generar Presupuesto">
   	    <button type="submit" class="btn btn-danger">Cancelar</button>
	    
	</form>
</div>

<%@include file='../../templates/Footer.jsp' %>