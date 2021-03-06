<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="MudanzasPepe">
<meta name="author" content="Erika Romanczuk">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Administrador</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
</head>
<style>
.navbar-login {
	width: 305px;
	padding: 10px;
	padding-bottom: 0px;
}

.navbar-login-session {
	padding: 10px;
	padding-bottom: 0px;
	padding-top: 0px;
}

.icon-size {
	font-size: 87px;
}
</style>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
	
			<a class="navbar-brand" href="index_administrador"> <img src="img/logo.png" height="35px"/> Mudanzas Pepe </a>
			<div class="nav navbar-nav navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="listaDePresupuestosAceptados">Aceptar
							Presupuestos</a></li>
					<li><a href="abmUsuario">ABM Usuario</a></li>
					<li><a href="abmVehiculo">ABM Vehiculo</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Informes <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="informePresupuestosFacturados">Presupuestos Facturados</a></li>
							<li><a href="informeViajesActivos">Viajes Activos</a></li>
							<li><a href="informeViajesFinalizados">Viajes Finalizados</a></li>
							<li><a href="graficoDePresupuestos">Estados de Presupuesto Grafico</a></li>
							<li><a href="graficoDeRentabilidad">Grafico de rentabilidad</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span> 
							<strong>Mi cuenta</strong> <span
							class="glyphicon glyphicon-chevron-down"></span>
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
											<p class="text-left">
												<strong>Administrador</strong>
											</p>

											<p class="text-left">
												<a href="profile" class="btn btn-primary btn-block btn-sm">Actualizar
													Datos</a>
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
												<a href="index" class="btn btn-danger btn-block">Cerrar
													Sesion</a>
											</p>
										</div>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>