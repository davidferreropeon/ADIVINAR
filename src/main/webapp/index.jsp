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

    <title>ahorcado</title>

    <!-- Bootstrap core CSS  DFDFDF-->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <link rel="stylesheet" href="css/styles.css">
  
  </head>
	
	
<body>
<c:if test="${not empty acierto}">	

<h1>HAS GANADO</h1>
	<div class="alert alert-info alert-dismissible fade show" role="alert">
		<strong>La palabra correcta es <p class= "respuesta">${palabra}</p></strong>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

	<form  class="form-signin" action="adivina" method="post" action="login">
		<button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
			VOLVER A EMPEZAR
		</button>
	</form>
</c:if>
<c:if test="${empty acierto}">	

   <section class = "flex-row" >
   		<h1>Ahorcado</h1>
   	
	   	<div class="col-sm-6">
			<div class="alert alert-info alert-dismissible fade show" role="alert">
				<strong>${mensaje}</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
	   	
		   	<div class="col-sm-6">
			  	<div  id="ahorcado" class="fallo${contador}"></div> 
			  	<script src="js/main.js"></script> 
			</div>
		</div>		
	</section>
	
	<form  class="form-signin" action="adivina" method="post" action="login">
		<c:if test="${contador!=7}">   	  
	  	 	<div class="mb-1"> 
			   <input type="text" id="letra1" name=letra1 placeholder="letra 1"  class="form-control">
			   <input type="text" id="letra2" name=letra2 placeholder=" letra 2"  class="form-control">
		 	</div>
		    <button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
				PROBAR SUERTE
			</button>
		</c:if>
		<c:if test="${contador==7}">   	
 			<button class="btn btn-lg  btn-block mb-3 mt-3  btn-info" type="submit">
				VOLVER A EMPEZAR
			</button>
		</c:if>
	</form>
	
	<p>numero intentos:
    	<c:if test="${not empty contador}">	  
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				 ${contador}/${maxInt}	 
			</div>	 	
	 	</c:if>
	 </p> 


<label class="alert alert-info alert-dismissible fade show" >${letra1}</label>
<label class="alert alert-info alert-dismissible fade show" >${letra2}</label>

</c:if>

</body>	

</html>