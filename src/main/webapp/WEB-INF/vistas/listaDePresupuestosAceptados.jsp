<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_administrador.jsp' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Presupuestos Aceptados</title>
</head>
<body>
<div class="container">
	<h1> Lista de Presupuestos aceptados </h1>
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
                                 <div class="col-xs-3">Asignar Chofer</div>
                                 <div class="col-xs-3">Rechazar</div>
                            </div>
                        </li>
                    </ul>
                  <c:forEach items="${listaMovimientos}" var="mov">
                    <ul class="list-group list-group-body" style="">
                        <li class="list-group-item">
                            <div class="row">
                                <div class="col-xs-4 text-left" style=" "> <a><span class="glyphicon glyphicon-file" aria-hidden="true"></span>${mov.letra} ${mov.puntoventa} - ${mov.numero}</a> </div>
                                <div class="col-xs-2" style="">${mov.fecha}</div>
                                <div class="col-xs-3" style="">${mov.viaje.precio}</div>
                                <div class="col-xs-3" style=""><a href="#" class="btn btn-primary a-btn-slide-text"> <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> <span><strong>Facturar</strong></span>             </a></div>
                                <div class="col-xs-3" style=""><a href="#" class="btn btn-primary a-btn-slide-text"> <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> <span><strong>Rechazar</strong></span>             </a></div>
                            </div>
                        </li>
                    </ul>
                      </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
	    

</body>
</html>