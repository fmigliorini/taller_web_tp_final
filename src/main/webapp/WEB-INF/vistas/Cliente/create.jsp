<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Cliente</title>
<!-- Incluimos el header -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-12">
				<h3 class="titulo">Nuevo Cliente</h3>
				<form >
					<div class="form-group">
						<label for="nombre">Nombre</label> 
						<input type="text" class="form-control" id="nombre"
							 placeholder="Ingresar nombre"> 
					</div>
					<div class="form-group">
						<label for="apellido">Apellido</label> <input
							type="text" class="form-control" id="apellido"
							placeholder="Ingresar apellido">
					</div>
					<div class="form-group">
						<label for="company">Company</label> <input
							type="text" class="form-control" id="company"
							placeholder="Ingresar company">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>