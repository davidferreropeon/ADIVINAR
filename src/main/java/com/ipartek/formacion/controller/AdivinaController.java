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
	


	// do get para recibir formulario al pulsar nueva multa
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	// DO POST PARA CREAR MULTA SDS
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String palabra = request.getParameter("palabra");
	

if (palabra.equals("pepe")) {
	
	request.setAttribute("mensaje", "has adivinado la palabra");
	request.getRequestDispatcher("index.jsp").forward(request, response);
}else {
	
	request.setAttribute("palabra", palabra);  // para que salga la palabra que has escrito
	request.setAttribute("mensaje", "has fallado");
	request.getRequestDispatcher("index.jsp").forward(request, response);

}

}
}