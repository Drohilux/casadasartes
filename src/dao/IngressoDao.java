package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import negocio.Ingresso;

public class IngressoDao {
	public static void create(Ingresso ingresso) {
    	
    	Transaction transaction = null;
    	
    	Session session = ConexaoDao.getSessionFactory().openSession();  	
    	
    	try {
    		transaction = session.beginTransaction();		
    		session.save(ingresso);
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
 
  public static Ingresso read(long id) {
	  Ingresso ingresso = null;     
         
    	 Session session = ConexaoDao.getSessionFactory().openSession(); 
    	 Transaction transaction = null;
    	 
         try {
        	 transaction = session.beginTransaction();
             String queryString = "from Cliente where id = :id";
             Query query = session.createQuery(queryString);
             query.setLong("id", id);
             
             ingresso = (Ingresso) query.uniqueResult();
             
         } catch (RuntimeException e) {	        	 
             e.printStackTrace();
             
         } finally {
             session.flush();
             session.close();
             
         }return ingresso;
   } 
}