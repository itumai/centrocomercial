<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navcliente.jsp"%>

<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">${nombre_tienda}</h2>
				<h3 class="section-subheading text-muted">${tipo_tienda}</h3>
			</div>
		</div>
		<div class="row">
			<c:forEach var="producto" items="${lista_productos}">		
			<div class="col-sm-4">
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/${producto.ruta_imagen}" height=255px; width=255px; class="img-responsive img-circle" alt="">
					<h4>${producto.nombre}</h4>
					<p class="text-muted">${producto.descripcion}</p>
					<ul class="list-inline social-buttons">
						<li><a href="clientes/cuenta/${producto.id}"><i class="fa fa-plus fa-3x fa-stack-2x text-primary"></i></a></li>
					</ul>
				</div>
			</div>
			</c:forEach>
		</div>		
	</div>
</section>

<%@include file="../includes/footercliente.jsp"%>