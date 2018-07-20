<div class="container">
	<!-- BREADCRUMB -->
	<div class="row">
		<div class="col-xs-12 col-lg-12" style="margin-top:30px;">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Product</a></li>
				<li class="breadcrumb-item" class="active">${product.name}</li>
			</ol>
		</div>
	</div>
	
	<!--  -->
	<div class="row">
		<!-- PRODUCT IMAGE -->
		
		<div class="col-xs-12 col-sm-4 ">
			<!-- style bootstrap 3-->
			<!-- 
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
			</div>
			 -->
			 <!-- Style bootstrap 4 -->
				<img src="${images}/${product.code}.jpg" class="img img-fluid img-thumbnail"/>
		</div>
		<!--  DETAIL INFO -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr />
			<h4>Price: <strong> &#36; ${product.unitPrice}</strong></h4>
			<hr />
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>Qty. Available: <span style="color:tomato;">Out of Stock!</span></h6>
					<a href="javascript:void(0);" class="btn btn-danger disable"> <del> <span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</del></a>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
					<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
				</c:otherwise>
				
			</c:choose>
			<a href="${contextRoot}/listProducts" class="btn btn-default">Back</a>
		</div>
	</div>
</div>