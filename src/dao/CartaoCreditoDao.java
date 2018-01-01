package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import negocio.CartaoCredito;

public class CartaoCreditoDao {
	
	public static void create(CartaoCredito cartao) {
	    	
	    	Transaction transaction = null;
	    	
	    	Session session = ConexaoDao.getSessionFactory().openSession();  	
	    	
	    	try {
	    		transaction = session.beginTransaction();		
	    		session.save(cartao);
	    		session.getTransaction().commit();
	    		
	    	}catch(RuntimeException e) {	    		
	    		if (transaction != null) {
	    			transaction.rollback();
	    			
	            }e.printStackTrace();
	            
	    	}finally {
	    		session.flush();
	    		session.close();
	    	}  	
	    }
	 
	  public static CartaoCredito read(long id) {
		  CartaoCredito cartao = null;     
	         
	    	 Session session = ConexaoDao.getSessionFactory().openSession(); 
	    	 Transaction transaction = null;
	    	 
	         try {
	        	 transaction = session.beginTransaction();
	             String queryString = "from Cliente where id = :id";
	             Query query = session.createQuery(queryString);
	             query.setLong("id", id);
	             
	             cartao = (CartaoCredito) query.uniqueResult();
	             
	         } catch (RuntimeException e) {	        	 
	             e.printStackTrace();
	             
	         } finally {
	             session.flush();
	             session.close();
	             
	         }return cartao;
	   } 
}