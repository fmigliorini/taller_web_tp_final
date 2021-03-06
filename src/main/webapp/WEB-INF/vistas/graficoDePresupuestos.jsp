
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {	'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChartPresupuestos);

	function drawChartPresupuestos() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Estado');
		data.addColumn('number', 'Cantidad de presupuesto por estado');
		data.addRows([ [ 'Activo', ${activo} ],
				[ 'Aceptado', ${aceptado} ],
				[ 'Reachazado', ${rechazado} ],
				[ 'Vencido', ${vencido} ],
				[ 'Facturado', ${facturado} ] ]);
		var options = {
			'title' : 'Presupuestos realizados por estados',
			'width' : 450,
			'height' : 400
		};
		var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
		chart.draw(data, options);
	}
</script>
<title>Grafico</title>
</head>
<body>

	<div class="content-wrapper" style="margin-top: 60px">

		<h1>Bienvenido a Graficos</h1>

		<div class="container">
			<div class="col-sm-10 no-gutter">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Grafico de estados de un presupuesto</h3>
					</div>
					<div class="panel-body">
						<p>En este grafico podremos visualizar la cantidad de
							presupuestos efectuados por su tipo de estado</p>
						<div id="chart_div1"></div>
					</div>
				</div>
			</div>
		</div>

	</div>

<%@include file='../../templates/Footer.jsp'%>
