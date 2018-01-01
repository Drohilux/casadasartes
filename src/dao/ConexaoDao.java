package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import negocio.Peca;

public class ConexaoDao {
	private static SessionFactory sessionF;
	
	public static
	
	SessionFactory getSessionFactory( ) {
		
		if(sessionF == null) {
			Configuration conf = new  Configuration().configure().addAnnotatedClass(Peca.class);
			sessionF = conf.buildSessionFactory();
			
		}return sessionF;
	}
}