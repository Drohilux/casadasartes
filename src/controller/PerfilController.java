package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.Cliente;
import service.ClienteService;

@WebServlet("/PerfilController")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PerfilController() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
	Cliente cliente = (Cliente) session.getAttribute("cliente");
	
	request.setAttribute("cliente",cliente);
	System.out.println(cliente.getNome());
    request.getRequestDispatcher("perfil.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}