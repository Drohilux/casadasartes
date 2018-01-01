package service;

import java.util.List;

import dao.ClienteDao;
import negocio.Cliente;

public class ClienteService {
	
	public static void criar(Cliente cliente){
		ClienteDao.create(cliente);		
	}
	
	public static Cliente clientePerfil(Long id){
		return ClienteDao.read(id);
	}
	
	public static void atualizaCadastro(Cliente cliente) {
		ClienteDao.update(cliente);
	}
	
	public static void excluir(long id) {
		ClienteDao.delete(id);
	}
	
	public static List<Cliente> list() {
		return ClienteDao.list();
	}
	
	public static Cliente logar(String login, String senha){
		return ClienteDao.logar(login, senha);
	}
}