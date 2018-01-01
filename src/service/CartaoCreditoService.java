package service;

import dao.CartaoCreditoDao;
import negocio.CartaoCredito;

public class CartaoCreditoService {
	public static void criar(CartaoCredito cartao){
		CartaoCreditoDao.create(cartao);		
	}
}