package com.ipartek.formacion.controller;

import java.io.IOException; //
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.HomePojo;


@WebServlet("/adivina")
public class AdivinaController extends HttpServlet {

private int contador=1;
private int maxIntentos=7;
	


	// do get para recibir formulario al pulsar nueva multa
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	// DO POST PARA CREAR MULTA SDS
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
			String letra1 = request.getParameter("palabra");
			String letra2 = request.getParameter("palabra2");
			
				
				try {
					
					if (letra1.equals("p")&& (letra2.equals("i"))) {	
							request.setAttribute("contador", contador);
							request.setAttribute("maxInt", maxIntentos);
							request.setAttribute("mensaje", "Has ganado");
							contador=1;	
							if (letra1 == "p") {
								
							}
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
					
				}finally {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
}