
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
	google.charts.load("current", {packages : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ "Descripcion", "Total$", {role : "style"	} ], 
				[ "Viaje Ganancia", ${viajeTotal}, "#60e560" ],
				[ "Log Viaje Gastos", ${logViajeTotal}, "#8fec8f" ]]);
		 var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);

	      var options = {
	        title: "Rentabilidad de viajes",
	        width: 600,
	        height: 400,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
	      chart.draw(view, options);
	}
</script>
<title>Grafico</title>
</head>
<body>

	

	<div class="container">
	<h2>Bienvenido a Graficos</h2>
		<div class="col-sm-10 no-gutter">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Grafico de Rentabilidad</h3>
				</div>
				<div class="panel-body">
					<p>En este grafico podremos visualizar la rentabilidad entre
						viaje la ganancia de viaje y sus logs de viaje</p>
					<div id="columnchart_values" ></div>
				</div>
			</div>
		</div>
	</div>


	<%@include file='../../templates/Footer.jsp'%>