package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Cliente;
import service.ClienteService;

@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("perfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");		
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		
		ClienteService.criar(cliente);
		
		System.out.print("Cadastrado realizado com Sucesso");
		request.setAttribute("cliente", cliente);
		
		request.getRequestDispatcher("/LoginController").forward(request, response);		
	}
}