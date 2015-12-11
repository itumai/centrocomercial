<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navcliente.jsp"%>


<section id="portfolio" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="timeline">
					<li>
						<div class="timeline-image">
							<img
								src="${pageContext.request.contextPath}/resources/images/logo_mmm.png"
								alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>Centro Comercial M&M's</h4>
							</div>
							<div class="timeline-body">
								<p class="text-muted">Aquí podrás disfrutar de nuestro
									mejores productos, desde nuestras deliciosas chucherías hasta
									nuestra moda mas chic. A continuación tienes a tu disposición
									todas nuestras tiendas. ¡Haz un click en la que más te guste!</p>
							</div>
						</div>
					</li>
				</ul>
			</div>

			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading"></h2>
					<h3 class="section-subheading text-muted"></h3>
				</div>
			</div>			

			<c:forEach var="tienda" items="${lista_tiendas}">
				<div class="col-md-4 col-sm-6 portfolio-item">
					<a href="tiendas/${tienda.tipo}/${tienda.id}" class="portfolio-link" data-toggle="modal">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fa fa-plus fa-3x"></i>
							</div>
						</div> <img
						src="${pageContext.request.contextPath}/${tienda.ruta_imagen}"
						class="img-responsive" alt="">
					</a>
					<div class="portfolio-caption">
						<h4>${tienda.nombre}</h4>
						<p class="text-muted">${tienda.descripcion}</p>
					</div>
				</div>
			</c:forEach>
			
		</div>
	</div>
</section>

<%@include file="../includes/footercliente.jsp"%>


