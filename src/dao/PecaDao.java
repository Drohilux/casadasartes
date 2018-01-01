package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import negocio.Peca;

public class PecaDao {
	public static void create(Peca peca) {    	
		   
		   Transaction tr = null;
	    	
	    	Session session = ConexaoDao.getSessionFactory().openSession();
	    	    	
	    	try {    		
	    		tr = session.beginTransaction();		
	    		session.save(peca);
	    		session.getTransaction().commit();
	    		
	    	}catch(RuntimeException e) {    		
	    		if (tr != null) {
	                tr.rollback();
	            }
	            e.printStackTrace();
	           
	            
	    	}finally {    	
	    		session.flush();
	    		session.close();
	    		 
	    	}  	
	    }
	   
	    public static Peca read(Long id) {
	    	 
	    	Peca peca = null;
	         Transaction tr = null;
	         
	    	 Session session = ConexaoDao.getSessionFactory().openSession();  	
	    	 
	         try {        	 
	             tr = session.beginTransaction();
	             String queryString = "from Peca where id = :id";
	             Query query = session.createQuery(queryString);
	             query.setLong("id", id);
	             
	             peca = (Peca) query.uniqueResult();
	             
	         } catch (RuntimeException e) {        	 
	             e.printStackTrace();
	             
	         } finally {        	 
	             session.flush();
	             session.close();
	         }
	         return peca;
	     }
	   
	    public static void update(Peca peca) {
	    	
	    	Transaction tr = null;
	    	
	    	Session session = ConexaoDao.getSessionFactory().openSession();  		    	
	    	
	    	try {
	    		
	    		tr = session.beginTransaction();		
	    		session.update(peca);    		
	    		session.getTransaction().commit();
	    		
	    	}catch(RuntimeException e) {    		
	    		if (tr != null) {
	                tr.rollback();
	            }
	            e.printStackTrace();
	           
	            
	    	}finally {    	
	    		session.flush();
	    		session.close();
	    		 
	    	}  	
	    }
	    
	    public static void delete(Long id) {
	    	
	    	Transaction tr = null;
	    	
	    	Session session = ConexaoDao.getSessionFactory().openSession();  		    	
	    	
	    	try {
	    		
	    		tr = session.beginTransaction();		
	    		Peca peca = (Peca)session.load(Peca.class, id);
	    		session.delete(peca);
	    		session.getTransaction().commit();
	    		
	    	}catch(RuntimeException e) {
	    		
	    		if (tr != null) {
	                tr.rollback();
	            }
	            e.printStackTrace();
	           
	            
	    	}finally {
	    	
	    		session.flush();
	    		session.close();    		 
	    	}  	
	    }
	    
	    public static List<Peca> list() {
	      	 
	    	List<Peca> peca = null;     
	        
	   	 Session session = ConexaoDao.getSessionFactory().openSession(); 
	   	 Transaction tr = null;
	   	 
	        try {       	 
	            tr = session.beginTransaction();
	            String queryString = "from Peca";
	            Query query = session.createQuery(queryString);             
	            
	            peca = (List<Peca>) query.list();
	            
	        } catch (RuntimeException e) {
	       	 
	            e.printStackTrace();
	            
	        } finally {
	       	 
	            session.flush();
	            session.close();
	        }
	        return peca;
	    }
}