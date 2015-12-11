<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navcliente.jsp"%>

<section id="formulario" class="bg-light-gray">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Modificar cliente</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="modificarclienteForm" method="post" action="clientes/modificar"
							modelAttribute="cliente">
							
							<div class="form-group">
								<form:input id="user" name="user" path="user"
									placeholder="Nombre de usuario" value="${client.user}" />
							</div>
							<div class="form-group">
								<form:password id="pass" name="pass" path="pass"
									placeholder="Contraseña" />
							</div>
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" value="${client.nombre}"/>
							</div>
							<div class="form-group">
								<form:input id="apellidos" name="apellidos" path="apellidos"
									placeholder="Apellidos" value="${client.apellidos}"/>
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<button type="submit" class="btn btn-xl">Guardar</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>




<%@include file="../includes/footercliente.jsp"%>