<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>   
	
	        <meta charset="utf-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	        	    <meta name="description" content="MudanzasPepe">
	    <meta name="author" content="Erika Romanczuk">
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Menu Administrador</title>

	        
	        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
	</head>
	       <style>

	        <a class="navbar-brand" href="index_administrador">Fletes Pepe </a>
.navbar-login
{
    width: 305px;
    padding: 10px;
    padding-bottom: 0px;
}

.navbar-login-session
{
    padding: 10px;
    padding-bottom: 0px;
    padding-top: 0px;
}

.icon-size
{
    font-size: 87px;
}
	</style>
	<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container"> 
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span> 
            </button>
            </div>
        <div class="nav navbar-nav navbar-right">
            <ul class="nav navbar-nav">
                <li><a href="listaDePresupuestosAceptados">Aceptar Presupuestos</a></li>
                <li><a href="reportesDeViajes">ABM Chofer</a></li>
                <li><a href="ABMVehiculo">ABM Vehiculo</a></li>
                <li><a href="contacto">Contacto</a></li> 
                 <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Informes
                    <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="InformePresupuestosAceptados">Presupuestos Aceptados</a></li>
                        <li><a href="InformePresupuestosRechazados">Presupuestos Rechazados</a></li>
                        <li><a href="InformePresupuestosFacturados">Presupuestos Facturados</a></li>
                        <li><a href="InformePresupuestosEstados">Estados de Presupuesto Grafico</a></li>
                    </ul>
                 </li>              
   
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong>Mi cuenta</strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <p class="text-center">
                                            <span class="glyphicon glyphicon-user icon-size"></span>
                                        </p>
                                    </div>
                                    <div class="col-lg-8">
                                        <p class="text-left"><strong>Nombre Apellido</strong></p>
                                        <p class="text-left small">correoElectronico@email.com</p>
                                        <p class="text-left">
                                            <a href="profile" class="btn btn-primary btn-block btn-sm">Actualizar Datos</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="navbar-login navbar-login-session">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>
                                            <a href="#" class="btn btn-danger btn-block">Cerrar Sesion</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

	</body>
</html>