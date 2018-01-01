package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.CartaoCredito;
import service.CartaoCreditoService;
import service.PecaService;

@WebServlet("/PagamentoController")
public class PagamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PagamentoController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PecaService.escolhida(Long.parseLong(request.getParameter("id")));		
		request.setAttribute("id", PecaService.escolhida(Long.parseLong(request.getParameter("id"))));
		
		request.getRequestDispatcher("pagamento.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String nomeCartao = request.getParameter("nomeCartao");
		int numero = Integer.parseInt(request.getParameter("numero"));
		int validade = Integer.parseInt(request.getParameter("validade"));
		int cvc = Integer.parseInt(request.getParameter("cvc"));
		
		CartaoCredito cartao = new CartaoCredito();
		cartao.setNomeCartao(nomeCartao);
		cartao.setNumero(numero);
		cartao.setValidade(validade);
		cartao.setCvc(cvc);
		
		CartaoCreditoService.criar(cartao);
		
		request.setAttribute("cartao", cartao);
		
		request.getRequestDispatcher("/SucessoController").forward(request, response);
	}
}