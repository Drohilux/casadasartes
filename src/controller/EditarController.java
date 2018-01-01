package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.Cliente;
import service.ClienteService;

@WebServlet("/EditarController")
public class EditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("editar.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");		
		HttpSession session = request.getSession();
		
		Cliente cliente = new Cliente();
		Cliente c = (Cliente)session.getAttribute("cliente");
		cliente.setId(c.getId());
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		
		ClienteService.atualizaCadastro(cliente);
		
		response.sendRedirect("/ProjetoBlocoJava/ClienteController");
	}
}