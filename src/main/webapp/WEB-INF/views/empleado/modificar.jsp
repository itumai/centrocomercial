<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navempleado.jsp"%>

<section id="formulario" class="bg-light-gray">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Modificar empleado</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="modificarempleadoForm" method="post" action="empleados/modificar"
							modelAttribute="empleado">
							
							<div class="form-group">
								<form:input id="user" name="user" path="user"
									placeholder="Nombre de usuario" value="${emple.user}"/>
							</div>
							<div class="form-group">
								<form:password id="pass" name="pass" path="pass"
									placeholder="Contraseña" />
							</div>
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" value="${emple.nombre}"/>
							</div>
							<div class="form-group">
								<form:input id="apellidos" name="apellidos" path="apellidos"
									placeholder="Apellidos" value="${emple.apellidos}"/>
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


<%@include file="../includes/footerempleado.jsp"%>