package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.projetojavaweb.models.Usuario;

@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet {

	private static final long serialVersionUID = 7395376983899583006L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String email = null;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("email")) {
					email = cookie.getValue();
					break;
				}
			}
		}
		
		String emailReq = request.getParameter("email");
		if(email == null  && emailReq != null && !emailReq.isEmpty()) {
			email = emailReq;
		}
		
		if(email == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/coletaEmail");
			dispatcher.forward(request, response);
		} else {
			
			response.setCharacterEncoding("ISO-8859-1");
			response.setContentType("text/html");	
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

			PrintWriter out = response.getWriter();
			out.println("<html> <head>");
			out.println("<title>Sistema - Home</title>");
			out.println("</head> <body>");
			out.println("<h1>Bem vindo - " + usuario.getLogin() + " ! " + "</h1>");
			out.println("<h1>Seu email é " + email + "</h1>");
			out.println("<h3>Esta é a páginha principal do sistema</h3>");
			out.println("<h3><a href=\"login.html\">Logout</a></h3>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
