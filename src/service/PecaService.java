package service;

import java.util.List;

import dao.PecaDao;
import negocio.Peca;

public class PecaService {
	public static List<Peca> list(){
		return PecaDao.list();
	}
	
	public static Peca escolhida(Long id) {
		return PecaDao.read(id);
	}
}