package com.ipartek.formacion.controller;

import java.io.IOException; //



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ipartek.formacion.pojo.Palabra;


@WebServlet("/adivina")
public class AdivinaController extends HttpServlet {


private static final long serialVersionUID = 1L;
private int contador=1;
private int maxIntentos=7;

private String correcta="pi";

	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
			String letra1 = request.getParameter("letra1");
			String letra2 = request.getParameter("letra2");
			String palabra = (letra1 + letra2); 
			
				
				try {
			
				
					if (palabra.equals(correcta)) {	
							request.setAttribute("contador", contador);
							request.setAttribute("maxInt", maxIntentos);
							request.setAttribute("mensaje", "Has ganado");
							request.setAttribute("acierto", "acierto");
							request.setAttribute("palabra", palabra);
						
							contador=1;	
						
					}else {	
						if (contador < maxIntentos) {
							
						request.setAttribute("letra1", letra1); 
						request.setAttribute("letra2", letra2);// para que salga la palabra que has escrito
						request.setAttribute("mensaje", "Has fallado, prueba otra vez");					
						request.setAttribute("contador", contador);
						request.setAttribute("maxInt", maxIntentos);
						contador ++;
						
						}else if (contador== maxIntentos) { 		
							request.setAttribute("mensaje", "Has perdido");
							request.setAttribute("contador", contador);
							request.setAttribute("maxInt", "No tienes mas intentos");
							contador=1;	
						}
						
						
						 // todo que no empiece vacio
					}	
					
					
				}catch ( Exception e) {
					request.setAttribute("mensaje", "Comienzas de nuevo");
				}finally {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
}