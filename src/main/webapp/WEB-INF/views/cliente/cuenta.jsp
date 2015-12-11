<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navcliente.jsp"%>

<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">MI CUENTA DE CLIENTE</h2>
				<h3 class="section-subheading text-muted">Última conexión:
					${cliente.hora_conexion}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<ul class="timeline">
					<li>
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="${pageContext.request.contextPath}/${cliente.ruta_imagen}"
								height=156px; width=156px; alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>${cliente.nombre} ${cliente.apellidos}</h4>
								<p class="text-muted">${cliente.user}</p>
							</div>
							<div class="timeline-body">								
								<a href="clientes/modificar" class="btn btn-xl">Modificar datos</a>						
							</div>
							<div class="row">
		<div class="col-lg-12 text-center">
			<h2 class="section-heading"></h2>
		
		</div>
	</div>
							<div class="timeline-body">								
								<a href="clientes/borrar" class="btn btn-xl">Borrar cuenta</a>						
							</div>

						</div>
					</li>
					<li class="timeline-inverted">
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="${pageContext.request.contextPath}/resources/images/producto/default.png"
								height=156px; width=156px; alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>Lista de mis productos</h4>
							</div>
							<div class="timeline-body">
								<p class="nuevoprod">${nuevo}</p>
								<c:forEach var="producto" items="${lista_productos}">
									<p class="text-muted">${producto.nombre}</p>
								</c:forEach>
							</div>
						</div>
					</li>

				</ul>
			</div>
		</div>
	</div>
</section>

<%@include file="../includes/footercliente.jsp"%>