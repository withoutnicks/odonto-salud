
function eliminar(codpro) {
	console.log(codpro);
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer el Producto!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/eliminar/"+codpro,
				 success: function(res) {
					console.log(res);
				},
			  });
		    swal("Poof! El producto ha sido eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/listar";
		    	}
		    });
		  }
		});
}