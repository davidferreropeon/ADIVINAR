<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang=es>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Acceso Agente</title>

    <!-- Bootstrap core CSS  DFDFDF-->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  </head>
	
	
<body>
	<div class="alert alert-info alert-dismissible fade show" role="alert">
		  <strong>${mensaje}</strong>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
	</div>
	
	<form  class="form-signin" action="adivina" method="post" action="login">
	   
	   		<h1 class="h3 mb-3 font-weight-normal">Adivina la palabra</h1>
	   	   	  
	  	 	<div class="mb-1"> 
			   <label for="palabra" >Escribe una palabra</label>
			   <input type="text" id="palabra" name=palabra class="form-control">
		 	</div>

		      <button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
		      Acceder
		      </button>

	</form>
	
	<p>${palabra}</p>
	
	<label for="concepto">Concepto  <span id="contadorLabel">(0/250)</span></label>
	<p>${contador}/${maxInt}</p>


 <script>
         
       let label;
       let concepto; //textarea
       
       const MAX_INTENTOS = 7; 
       const MIN_INTENTOS = 0;
       
       window.addEventListener('load', function() {
           
           console.log('el DOM cargado y listo');
           label   = document.getElementById('contadorLabel');
           concepto = document.getElementById('concepto');
            
           label.textContent = `0/`+ MAX_INTENTOS;
           label.style.color = 'orange';
           
           concepto.addEventListener("keyup", function(){
               
               let caracteres = concepto.value.length;                             
               
               if( caracteres < MIN_INTENTOS ){
                    label.style.color = 'orange';   
               }else if ( caracteres  > MAX_INTENTOS ){
                   concepto.value = concepto.value.substr(0,MAX_INTENTOS);
               }else{
                    label.style.color = 'green';
               }
               
               caracteres = concepto.value.length;
               label.textContent = caracteres + `/`+ MAX_INTENTOS;
               
           });
           
           
       });
    
   </script>
   


</body>	

</html>