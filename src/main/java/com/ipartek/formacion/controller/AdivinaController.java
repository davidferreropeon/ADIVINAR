package com.ipartek.formacion.controller;

import java.io.IOException; //

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.Dao.PalabraDAO;
import com.ipartek.formacion.pojo.Palabra;

@WebServlet("/adivina")
public class AdivinaController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	
	// variables parametros
	
	//private String letra1;
	//private String letra2;
	
	
	// variables logica
	private int contador=1;
	private int maxIntentos=7;
	//private String correcta="pi";
	
	// dao y objetos
	private PalabraDAO palabraDAO = null;
	Palabra palabraBaseDatos = null;
	
		
	// init para validator, dao , objetos y colecciones
	@Override  
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
		palabraDAO = PalabraDAO.getInstance();
		palabraBaseDatos = new Palabra();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  // palabra parametros en un string
		
		String letra1 = request.getParameter("letra1");
		String letra2 = request.getParameter("letra2");
		String id = request.getParameter("id");	
	
		String palabraParametros = (letra1 + letra2); // palabra con parametros
			
	
		try {	
				Long identificador = Long.parseLong(id);
				Palabra ObjetoParametros = new Palabra (identificador,letra1,letra2); //objeto con parametros
						
				  // palabra para guardar la de la base de datos
				
				Palabra p = new Palabra();
				 p = palabraDAO.getPalabra(letra1, letra2);  
				 p.getLetra1();
				 if (p != null) { 
				//if ( p.equals(ObjetoParametros) ) {
					
					request.setAttribute("mensaje","has ganado");
					request.setAttribute("contador", contador);
					request.setAttribute("maxInt", maxIntentos);
					request.setAttribute("mensaje", "Has ganado");
					request.setAttribute("acierto", "acierto");
					request.setAttribute("letra1", p.getLetra1());
					request.setAttribute("letra2", p.getLetra2());
				
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

				}	
			
			}catch ( Exception e) {
				request.setAttribute("mensaje", "Comienzas de nuevo");
			}finally {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
	}

	
	
	
	}

	
	
	
	