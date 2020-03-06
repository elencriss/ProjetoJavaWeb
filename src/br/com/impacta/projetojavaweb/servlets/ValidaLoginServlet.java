package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.projetojavaweb.models.Usuario;

@WebServlet("/validaLogin")
public class ValidaLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7393894369402219133L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login != null && senha != null) {
			login = login.trim();
			senha = senha.trim();
			
			if(!login.isEmpty() && !senha.isEmpty() && senha.equals("admin123")) {			
								
				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);
				request.getSession().setAttribute("usuario", usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/sistema");
				dispatcher.forward(request, response);
				return;
			} 			
		}
		
		response.sendRedirect("/ProjetoJavaWeb/erroLogin.html");		
	}
}
