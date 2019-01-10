package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.daos.CocheDAO;
import com.ipartek.formacion.daos.MultaDAO;
import com.ipartek.formacion.pojos.Agente;
import com.ipartek.formacion.pojos.Coche;
import com.ipartek.formacion.pojos.Multa;

@WebServlet("/privado/multa")
public class MultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// LOG
	private final static Logger LOG = Logger.getLogger(MultaController.class);

	private ValidatorFactory factory;
	private Validator validator;

	// VISTAS
	private static final String VIEW_INDEX = "principal.jsp";
	private static final String VIEW_FORM = "multa.jsp";
	private String vista;

	// OPERACIONES
	public static final String OP_INSERTAR = "1";

	// parametros
	private String operacion;
	private String id_agente;
	private String id_coche;
	private String importe;
	private String concepto;
	private String matricula;

	private static MultaDAO MultaDAO = null;
	private static CocheDAO CocheDAO = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		MultaDAO = MultaDAO.getInstance();
		CocheDAO = CocheDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		vista = VIEW_INDEX;

		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (operacion) {
			case OP_INSERTAR:
				insertar(request);
				break;
			default:
				insertar(request);
				break;

			}

		} catch (Exception e) {
			LOG.error(e);
			vista = VIEW_FORM;

			Coche c = new Coche();
			c = CocheDAO.getMatricula(matricula);
			request.setAttribute("coche", c);
			request.setAttribute("mensaje", "ERROR FATAL");

		} finally {
			request.getRequestDispatcher(vista).forward(request, response);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void insertar(HttpServletRequest request) {

		// crear pojos mediante parametros del formulario

		Coche coche = new Coche();
		int coche_id = Integer.parseInt(id_coche);
		coche.setId((long) coche_id);

		Multa multa = new Multa();

//		if(importe.equals("")) {
//			multa.setImporte(null);
//		}else {
//		multa.setImporte(Integer.parseInt(importe));
//		}

		try {
			multa.setImporte(Integer.parseInt(importe));
		} catch (Exception e) {
			multa.setImporte(null);
		}
		multa.setConcepto(concepto);
		multa.setCoche(coche);

		Agente agente = new Agente();
		int agente_id = Integer.parseInt(id_agente);
		agente.setId((long) agente_id);

		// validar
		Set<ConstraintViolation<Multa>> violations = validator.validate(multa);

		if (violations.size() > 0) { // validacion NO correcta
			vista = VIEW_FORM;
			Coche c = new Coche();
			c = CocheDAO.getMatricula(matricula);
			request.setAttribute("coche", c);
			String mensaje = "<ul>";
			for (ConstraintViolation<Multa> violation : violations) {
				mensaje += String.format("<li> %s : %s </li>", violation.getPropertyPath(), violation.getMessage());
			}
			mensaje += "</ul>";
			request.setAttribute("mensaje", mensaje);
		} else { // validacion correcta
			try {
				MultaDAO.insert(multa, agente);
				request.setAttribute("mensaje", "Registro guardado con exito");
			} catch (SQLException e) {
				request.setAttribute("mensaje", "Lo sentimos pero el codigo del video existe");
			}
		}
	}

	private void getParametros(HttpServletRequest request) {

		operacion = request.getParameter("operacion");
		id_agente = request.getParameter("id_agente");
		id_coche = request.getParameter("id_coche");
		importe = request.getParameter("importe");
		concepto = request.getParameter("concepto");
		matricula = request.getParameter("matricula");
	}

}