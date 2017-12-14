<%@include file='../../templates/Header_web.jsp'%>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/indexStyle.css">

	<div id="tabs-home" class="row slider"
		style="background: url(img/mudanza03.jpg) no-repeat center fixed;">



		<div class="row">
			<div class="col-md-12 one-column-text">
				<h2 style="font-size: 36px; color: white;">Mudanzas Pepe</h2>
				<h3 style="font-size: 24px; color: white;">Gracias al trabajo
					responsable y la honestidad nos hemos mantenido en el mercado a lo
					largo de todos estos años. Contamos con personal altamente
					capacitado para todo tipo de traslados de corta y larga distancia.
					Ofrecemos un servicio completo, con precios accesibles para todos
					los clientes que nos eligen, con la seguridad que usted y sus
					muebles se merecen.</h3>
				</h3>
				</h3>
			</div>
		</div>


	</div>

	<div class="row steps">
		<h3>Nuestra Servicio</h3>
		<div class="col-md-4">
			<center>
				<img alt="Paso 1 - formulario online" src="img/paso1-formulario.jpg" />
			</center>
			<h4>Se registra en nuestra paguina. Alli podra generar
				presupuestos automaticos para sus mudanzas</h4>
		</div>
		<div class="col-md-4">
			<center>
				<img alt="Paso 2 - generación y revisión de documentos"
					src="img/paso2-documentos.jpg" />
			</center>
			<h4>Accepta el presupuesto y automaticamente se le genera la
				factura. Asi aceguramos una antencion rapida</h4>
		</div>
		<div class="col-md-4">
			<center>
				<img alt="Paso 3 - Firma en notaria" src="img/paso3-firma.jpg" />
			</center>
			<h4>En su perfil de usuario se guardan todas las facturas
				emitidas y tambien los presupuestos, brindandole asi un manejo mas
				amplio sobre sus facturas y presupuestos</h4>
		</div>
	</div>

	<h3
		style="font-size: 36px; font-weight: 300; color: #057d9f; text-align: center; margin: 50px 0 30px 0;">Lo
		que Opinan Nuestros Clientes</h3>

	<div class="row" id="opinion-left"
		style="background: url(img/C03.jpg) no-repeat center;">
		<div class="col-md-6">
			<h3>Seguro y rápido. Súper conforme</h3>
			<p>Nelson del Villar</p>
			<p>Co-Fundador de Antares, Concesionaria Engel & Volkers</p>

		</div>
	</div>

	<h3
		style="font-size: 36px; font-weight: 300; text-align: center; margin: 70px 0;">El
		Servicio Legal que Necesita a un Precio a su Alcance</h3>

	<div class="row features-home-left">
		<div class="col-md-7">
			<h3>Rápido</h3>
			<h4>Nuestro 1er. mudanzas.</h4>
			<p>En términos de velocidad nuestra tecnología nos permite volar.
				Mudanzas Pepe realiza la mudanza una vez facturada</p>
		</div>
		<div class="col-md-5">
			<img src="img/rapidez.jpg" />
		</div>
	</div>

	<div class="row features-home-right">
		<div class="col-md-5">
			<img alt="legalprom es economico" src="img/economico.jpg" />
		</div>
		<div class="col-md-7">
			<h3>Económico</h3>
			<h4>Un servicio del mas elevado estándar al mejor precio</h4>
			<p>Cuando generamos su presupuesto de manera automatica , con
				nuestros algoridmos calculamos que vehiculo es conveniente para
				usted dependiendo el peso , asi aseguramos que los costos no sean
				elevados</p>
		</div>
	</div>

	<div class="row features-home-left">
		<div class="col-md-7">
			<h3>Fácil y Claro</h3>

			<h3>Mudanzas en Capital Federal y en todo el país</h3>
			<p>Ofrecemos un servicio destacado de mudanzas a particulares y
				empresas en Capital Federal y a todo el pais.</p>
			<p>Nuestro servicio incluye</p>
			<ul>
				<li>El traslado de muebles y enseres</li>
				<li>Personal para carga y descarga</li>
				<li>Material necesario (cajas, canastos, roperos moviles, etc.)
					para asegurar sus pertenencias.</li>
			</ul>
		</div>
		<div class="col-md-5">
			<img alt="claridad y facilidad de legalprom" src="img/claridad.jpg" />
		</div>
	</div>



	<div class="line">
		<hr />
	</div>

	<div class="row">
		<div class="col-md-12 one-column-text">
			<h2 style="font-size: 36px;">Olvídese de Trámites y
				Complicaciones</h2>
			<h3 style="font-size: 24px;">Déje sus asuntos en manos de
				nuestro equipo y ocupe su tiempo su negocio</h3>

			<center>
				<img alt="Paso 1 - formulario online" src="img/cotiza01.png" />
			</center>
		</div>
	</div>
	<div class="row" id="opinion-right"
		style="background: url(img/C01.jpg) no-repeat center; margin-top: 0;">
		<div class="col-md-6"></div>
		<div class="col-md-6" style="color: white;">
			<h3>Sobresaliente servicio !</h3>
			<p>Rosario Sepúlveda</p>
			<p>Co-Fundadora de IngeAgro</p>

		</div>
	</div>

<script type="text/javascript">
	var stop = false;
	$(document)
			.ready(
					function() {
						var tabCarousel = setInterval(
								function() {
									var tabs = $('#tabs-home .nav.tabs > li'), active = tabs
											.filter('.active'), next = active
											.next('li'), toClick = next.length ? next
											.find('a')
											: tabs.eq(0).find('a');

									toClick.trigger('click');
								}, 5000);
					});
</script>
<%@include file='../../templates/Footer.jsp'%>
