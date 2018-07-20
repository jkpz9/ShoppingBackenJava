<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container" style="margin: 30px auto;">
	<div class="row">
		<c:if test = "${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss = "alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Products Management</h4>
				</div>
				<div class="panel-body">
					<!-- FORM -->
					
					<sf:form class="form-horizontal" modelAttribute="product"
							action="${contextRoot}/manage/products"
							method="POST"
							enctype="multipart/form-data"
					>
						<!--  Name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name: </label>
							<div class="col-md-8">
								<sf:input class="form-control" type="text" path="name" id="name" placeholder = "Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div> 
						
						<!--  brand -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Brand Name: </label>
							<div class="col-md-8">
								<sf:input class="form-control" type="text" path="brand" id="brand" placeholder = "Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!--  Description -->
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description: </label>
							<div class="col-md-8">
								<sf:textarea class="form-control" rows="8" cols="50" path="description" id="description" placeholder = "Describe some about the product ..."></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!--  price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter Price: </label>
							<div class="col-md-8">
								<sf:input class="form-control" type="number" path="unitPrice" id="unitPrice" placeholder = "Price in &#36;" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!--  Quantity -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter Available Quantity: </label>
							<div class="col-md-8">
								<sf:input class="form-control" type="number" path="quantity" id="quantity" placeholder = "Available Quantity" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						<!--  For Upload  IMG-->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Upload an Image:  </label>
							<div class="col-md-8">
								<sf:input class="form-control-file" type="file" path="file" id="file" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						<!--  Category -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Select a Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId" id="categoryId" items = "${categories}" itemLabel="name" itemValue="id">	
								</sf:select>
							</div>
						</div>
												
						<!--  Submit btn -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input class="btn btn-primary" type=submit id="submit" value="Submit" />
								
								<!-- product HIDDEN fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>
					</sf:form>
					
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-lg-12 col-md-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-xs-12 col-lg-12 col-md-12">
			<div style="overflow: auto;">
				<!-- products table for Admin -->
				<table id="adminProductTable" class="table table-striped table-bordered" >
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>