<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navempleado.jsp"%>

<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">MI CUENTA DE EMPLEADO</h2>
				<h3 class="section-subheading text-muted">Última conexión:
					${empleado.hora_conexion}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<ul class="timeline">
					<li>
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="${pageContext.request.contextPath}/${empleado.ruta_imagen}"
								height=156px; width=156px; alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>${empleado.nombre} ${empleado.apellidos}</h4>
								<p class="text-muted">${empleado.user}</p>
							</div>
							<div class="timeline-body">
								<a href="empleados/modificar" class="btn btn-xl">Modificar
									datos</a>
							</div>

						</div>
					</li>
					<li class="timeline-inverted">
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="${pageContext.request.contextPath}/resources/images/tienda/default.png"
								height=156px; width=156px; alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>${tienda.nombre}</h4>
								<p class="text-muted">Tienda de ${tienda.tipo}</p>
							</div>
							<div class="timeline-body">
								<a href="tiendas/modificar" class="btn btn-xl">Modificar
									datos</a>							
							</div>
						</div>
					</li>
					<li>
						<div class="timeline-image">
							<img class="img-circle img-responsive"src="${pageContext.request.contextPath}/resources/images/producto/default.png" 
							height=156px; width=156px;
								alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>Lista de mis productos</h4>
							</div>
							<div class="timeline-body">
								<c:forEach var="producto" items="${lista_productos}">
									<p class="text-muted"><!-- <a href="productos/modificarborrar/${producto.id}" class="text-muted" > -->${producto.nombre}<!-- </a> --></p>
								</c:forEach>
								<a href="productos/nuevo" class="btn btn-xl">Nuevo</a>							
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>


<%@include file="../includes/footerempleado.jsp"%>