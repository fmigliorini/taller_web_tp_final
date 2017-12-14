	<a class="navbar-brand" href="home"> <img src="img/logo.png" height="35px"/>  Mudanzas Pepe  </a>
<div class="nav navbar-nav navbar-right">
	<ul class="nav navbar-nav">
		<li><a href="${pageContext.request.contextPath}/presupuestoForm">Nuevo
				Presupuesto</a></li>
		<li><a
			href="${pageContext.request.contextPath}/listarPresupuestosCliente">Listar
				presupuesto</a></li>
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
									<strong>Cliente</strong>
								</p>
								<p class="text-left small"></p>
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
									<a href="${pageContext.request.contextPath}/cerrarSession"
										class="btn btn-danger btn-block">Cerrar Sesion</a>

								</p>
							</div>
						</div>
					</div>
				</li>
			</ul></li>
	</ul>
</div>