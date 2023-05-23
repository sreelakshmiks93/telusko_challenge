var dialog,table;
$(document).ready(function() {

  
    table = $('#tblReport').dataTable({
    "ajax": "/products",
    "columns": [{
        "data": "id"
      },
      {
        "data": "name"
      },
      {
        "data": "type"
      },
      {
        "data": "place"
      },
      {
        "data": "warranty"
      } 
    ]
  });
 

});
function addProduct(){
	var msg = 'Name: <input type="text" id="name" class="form-control">'
				+'Type: <input type="text" id="type" class="form-control">'
				+'Place: <input type="text" id="place"  class="form-control">'
				+'Warranty: <input type="number" id="warranty"  class="form-control">'
	  dialog = BootstrapDialog.show({
			title: "Add Product",
            message: msg,
            buttons: [{
                label: 'Close',
                action: function(dialogRef) {
                    dialogRef.close();
                }
                },
                {
                label: 'Submit',
                action: function(dialogRef) {
                    postToServer();
                }
                }
            ]
        });
}


function postToServer(){
	var data = {
         
            name: $("#name").val(),
            type: $("#type").val(),
            place: $("#place").val(),
            warranty: $("#warranty").val(),
          
     
	}
 
$.ajax({
    url:"/product",
    data:JSON.stringify(data),
    type:"POST",
    contentType:"application/json",
    success:function(response){
    if(response.status == 200){
	 BootstrapDialog.show({
            message: "Added Product Successfully",
            });
            dialog.close();
            table.DataTable().ajax.reload();
	$("#all_btn").css("background","#000");
	$("#warranty_btn").css("background","none");
    }else{
	 BootstrapDialog.show({
			title: "Failure",
            message: response.error,
            });
	}
	
}
    
 
});
  
}

function loadProductsOutOfWarranty(){
	table.DataTable().ajax.url("/products/warrantyexpired").load();
	$("#warranty_btn").css("background","#000");
	$("#all_btn").css("background","none");
}
function loadAll(){
	table.DataTable().ajax.url("/products").load();
	$("#all_btn").css("background","#000");
	$("#warranty_btn").css("background","none");
}