package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.Cliente;
import service.ClienteService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Cliente cliente =  ClienteService.logar(login, senha);
		HttpSession session = request.getSession();
		session.setAttribute("cliente", cliente);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PerfilController");
		dispatcher.include(request, response);
	}
}