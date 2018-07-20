$(function(){
	
	// solving the active menu problem
	switch(menu) {
	case "About US": 
		$('#about').addClass('active');
		break;
	case 'Contact US':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$("#a_"+menu).addClass('active');
		break;
	}
	
	// Jquery datatables

	var $table = $("#productListTable");
	
	// execute the below code only where we have this table
	if($table.length) {
		// console.log('Inside the table');
		
		var jsonUrl = '';
		
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable({
			lengthMenu: [[3, 5, 10, -1], ['3', '5', '10', 'All']],
			pageLength: 5,
			ajax : {
					url : jsonUrl,
					dataSrc: ''	
			},
			columns : [
				
				{
					data : 'code',
					mRender : (data, type, row) => {
						var img = '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "DatatableImg" />';
						return img;
					}
					
				},
				
				{
					data : 'name'
					
				},
				
				{
					data: 'brand'
				},
				
				{
					data: 'unitPrice',
					mRender: (data, type, row) => {
						return '&#36; ' + data; 
					}
				},
				
				{
					data : 'quantity',
					mRender : (data, type, row) =>  {
						if(data < 1) {
							return '<span style="color:red;">Out of Stock!</span>';
						}
						return data;
					}
				},
				
				{
					data : 'id',
					
					bSortable : false,
					
					mRender : (data, type, row) => {
						var opt = '';
						/*
						 * 
						 *opt += `<button type="button" class="btn btn-xs btn-danger">
						  <span class="glyphicon glyphicon-trash"></span>
						  </button>`;
						 *
						 * */
						opt += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-eye-open"></span></a>';
						
						if(row.quantity < 1) {
							opt += '<a href="javascrip:void(0)" class="btn btn-danger disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						
						else {
							opt += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						
						
						return opt;
					}
				}
					
			]
		});
	}
	
	// dismiss the alert after 3s
	var $alert = $('.alert');
	if($alert.length) {
		setTimeout(() => {
			$alert.fadeOut('slow');
			
		},3000);
	}
	
	//

	/* Admin datatable*/
	var $AminProductListTable = $("#adminProductTable");
	
	// execute the below code only where we have this table
	if($AminProductListTable.length) {
		// console.log('Inside the table');
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$AminProductListTable.DataTable({
			lengthMenu: [[10, 30, 50, -1], ['10', '30', '50', 'All']],
			pageLength: 30,
			ajax : {
					url : jsonUrl,
					dataSrc: ''	
			},
			columns : [
				
				{
					data : 'id',
						
				},
				
				{
					data : 'code',
					mRender : (data, type, row) => {
						var img = '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "adminDataTableImg " />';
						return img;
					}
					
				},
				
				{
					data : 'name'
					
				},
				
				{
					data: 'brand'
				},
				
				{
					data : 'quantity',
					mRender : (data, type, row) =>  {
						if(data < 1) {
							return '<span style="color:red;">Out of Stock!</span>';
						}
						return data;
					}
				},
				
				{
					data: 'unitPrice',
					mRender: (data, type, row) => {
						return '&#36; ' + data; 
					}
				},
				
				{
					data : 'active',
					bSortable : false,
					mRender : (data,type, row) => {
						var str = '';
						str += '<label class="switch">';
						str += '<input type="checkbox" value="'+row.id+'">';
  						str += '<span class="slider round"></span></label>';
						return str;
						
					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : (data, type, row) => {
						let str = `<a href="${contextRoot}/manage/`
							+ data+`/product" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>`;
						return str;
					}
				}
					
			],
			initComplete:function() {
				let api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', () => {
					let checkbox = $(this),
					checked = checkbox.prop('checked'),
					dMsg = (checked) ? 'Do you really want to active this product?' :
									   'Do you really want to deactive this product?';
				//let value = checkbox.prop('value');
				  let value = $(this).val();
				console.log(value);
				
				bootbox.confirm ({
					size: 'medium',
					title: 'Product Active && Deactive',
					message: dMsg,
					buttons: {
				        cancel: {
				            label: '<i class="fa fa-times"></i> Cancel'
				        },
				        confirm: {
				            label: '<i class="fa fa-check"></i> Confirm'
				        }
				    },
					callback: (confirmed) => {
						if(confirmed) {
							console.log(value);
							bootbox.alert({
								size:'medium',
								title:'Infomation',
								message: 'You are going to perform operation on product '+ value 
							});
						}
						else {
							checkbox.prop('checked', !checked);
						}
					}
				});
			})
			}
		});
	}
	/* End Admin datatable*/

});