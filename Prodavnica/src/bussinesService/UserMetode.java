package bussinesService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Product;

public class UserMetode {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public List<Product> vratiListuProizvoda(){
		
		List<Product> listOfProducts = new ArrayList<Product>();
		
		Session session = sf.openSession();
			session.beginTransaction();
				try {
					Query query = session.createQuery("FROM Product");
					listOfProducts = query.getResultList();
					session.getTransaction().commit();
					return listOfProducts;
				} catch (Exception e) {
					session.getTransaction().rollback();
					return null;
		}finally {
			session.close();
		}
		
	}
	
	
	
	
	
	
}
