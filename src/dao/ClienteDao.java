package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import negocio.Cliente;

public class ClienteDao {
	public static void create(Cliente cliente) {
    	
    	Transaction transaction = null;
    	
    	Session session = ConexaoDao.getSessionFactory().openSession();  	
    	
    	try {
    		transaction = session.beginTransaction();		
    		session.save(cliente);
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
 
  public static Cliente read(long id) {
    	Cliente cliente = null;     
         
    	 Session session = ConexaoDao.getSessionFactory().openSession(); 
    	 Transaction transaction = null;
    	 
         try {
        	 transaction = session.beginTransaction();
             String queryString = "from Cliente where id = :id";
             Query query = session.createQuery(queryString);
             query.setLong("id", id);
             
             cliente = (Cliente) query.uniqueResult();
             
         } catch (RuntimeException e) {	        	 
             e.printStackTrace();
             
         } finally {
             session.flush();
             session.close();
             
         }return cliente;
   }
  
  public static List<Cliente> list() {

        List<Cliente> cliente = null;

        Session session = ConexaoDao.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            String queryString = "from Cliente";
            Query query = session.createQuery(queryString);


            cliente = (List<Cliente>) query.list();

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {

            session.flush();
            session.close();
        }
        return cliente;
    }
   
  public static void update(Cliente cliente) {
    	
    	Transaction transaction = null;
    	
    	Session session = ConexaoDao.getSessionFactory().openSession();  	
    	
    	try {
    		transaction = session.beginTransaction();	
    		
    		session.update(cliente);    		
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
   
  public static void delete(long id) {
    	Transaction transaction = null;
    	
    	Session session = ConexaoDao.getSessionFactory().openSession();  	
    	
    	try {
    		transaction = session.beginTransaction();		
    		Cliente cliente = (Cliente)session.load(Cliente.class, id);
    		session.delete(cliente);
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
    
  public static Cliente logar(String login, String senha) {
    	
    	Cliente cliente = null;
    	   
         
    	 Session session = ConexaoDao.getSessionFactory().openSession(); 
    	 Transaction tr = null;
    	 
         try {
        	 
             tr = session.beginTransaction();
             String queryString = "from Cliente WHERE login = '" + login + "' AND senha = '" + senha + "'";
             Query query = session.createQuery(queryString);	             
             
             cliente = (Cliente) query.uniqueResult();
             
         } catch (RuntimeException e) {
        	 
             e.printStackTrace();
             
         } finally {
        	 
             session.flush();
             session.close();
         }
         return cliente;
     }
}