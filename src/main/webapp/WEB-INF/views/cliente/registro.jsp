<%@include file="../includes/head.jsp"%>
<%@include file="../includes/menu.jsp"%>

<section id="contact">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading">Nuevo cliente</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="registroclienteForm" method="post" action="registrocliente"
							modelAttribute="cliente">
							
							<div class="form-group">
								<form:input id="user" name="user" path="user"
									placeholder="Nombre de usuario" />
							</div>
							<div class="form-group">
								<form:password id="pass" name="pass" path="pass"
									placeholder="Contraseña" />
							</div>
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" />
							</div>
							<div class="form-group">
								<form:input id="apellidos" name="apellidos" path="apellidos"
									placeholder="Apellidos" />
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<button type="submit" class="btn btn-xl">Crear</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>


<%@include file="../includes/footer.jsp"%>

