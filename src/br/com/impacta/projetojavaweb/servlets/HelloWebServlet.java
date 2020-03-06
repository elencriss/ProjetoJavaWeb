package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWebServlet extends HttpServlet{

	private static final long serialVersionUID = -2710349887761109078L;
	
	public HelloWebServlet () {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append(" <h2> Mapeamento pelo web.xml </h2>");
	}

}
