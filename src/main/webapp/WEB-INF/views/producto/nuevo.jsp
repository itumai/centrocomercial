<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navempleado.jsp"%>

<section>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Nuevo producto</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
						
						<form:form id="productoForm" method="post" action="productos/nuevo"
							modelAttribute="producto">
							
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" />
							</div>
							<div class="form-group">
								<form:input id="descripcion" name="descripcion" path="descripcion"
									placeholder="Descripcion" />
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

<%@include file="../includes/footerempleado.jsp"%>