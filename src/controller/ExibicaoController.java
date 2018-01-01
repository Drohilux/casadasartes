package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PecaDao;
import negocio.Peca;
import service.PecaService;

@WebServlet("/ExibicaoController")
public class ExibicaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExibicaoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Peca> pecas = PecaService.list();
		request.setAttribute("pecas", pecas);
				
        RequestDispatcher rd = request.getRequestDispatcher("exibicao.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}