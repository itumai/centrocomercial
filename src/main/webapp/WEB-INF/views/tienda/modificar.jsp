<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navempleado.jsp"%>


<section id="formulario" class="bg-light-gray">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Modificar tienda</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">

						<form:form id="modificarForm" method="post"
							action="tiendas/modificar" modelAttribute="tienda">

							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Introduce nuevo nombre" value="${tien.nombre}"/>
							</div>
							<div class="form-group">
								<form:input id="descripcion" name="descripcion"
									path="descripcion" placeholder="Introduce nueva descripcion" value="${tien.descripcion}"/>
							</div>
							<div class="form-group">
								<form:input id="tipo" name="tipo" path="tipo"
									placeholder="Introduce nuevo tipo" value="${tien.tipo}"/>
							</div>
							<div class="form-group">
								<form:input id="horario_abrir" name="horario_abrir"
									path="horario_abrir" placeholder="Introduce nuevo horario" value="${tien.horario_abrir}"/>
							</div>
							<div class="form-group">
								<form:input id="horario_cerrar" name="horario_cerrar"
									path="horario_cerrar" placeholder="Introduce nuevo horario" value="${tien.horario_cerrar}"/>
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


