<div class="container">
	<div class="row">
		<!-- Would be to display sidebar -->
		<div class="col-md-3">
			 <%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- Display actual products -->
		<div class="col-md-9">
			<!-- Breadcrumb component -->
			<div class="row" style="margin-top:30px;">
				<div class="col-lg-12">
				
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${rootContext}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					
						<script>
							window.categoryId = '${category.id}';
						/*alert(window.categoryId);*/
						</script>
					
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${rootContext}/home">Home</a></li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
					
				</div>
			</div>
			<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<table id="productListTable" class="table table-bordered table-hover table-condensed">
						
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty. Available</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
							<tfoot>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Qty. Available</th>
									<th></th>
								</tr>
							</tfoot>
						
						</table>
					</div>
				</div>
		</div>
	</div>
</div>