package com.ipartek.formacion.controller;

import java.io.IOException; //

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("/adivina")
public class AdivinaController extends HttpServlet {
private String palabra;
private int contador=0;
private int maxInt=7;
	


	// do get para recibir formulario al pulsar nueva multa
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	// DO POST PARA CREAR MULTA SDS
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
			String palabra = request.getParameter("palabra");
				
				try {
					if (palabra.equals("pepe")) {
						
						request.setAttribute("mensaje", "has adivinado la palabra");
						if (contador != maxInt )
						contador ++;
						request.setAttribute("contador", contador);
						request.setAttribute("maxInt", maxInt);
						
					}else {
						
						request.setAttribute("palabra", palabra);  // para que salga la palabra que has escrito
						request.setAttribute("mensaje", "has fallado");
					
						contador ++;
						request.setAttribute("contador", contador);
					
					}
				}catch ( Exception e) {
					
				}finally {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
}