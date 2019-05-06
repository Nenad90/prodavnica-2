package bussinesService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Product;

public class AdminMetode {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public boolean ubaciProizvod(String name, double price, int stock, int quantity, double discount) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Product p = new Product();
			p.setName(name);
			p.setPrice(price);
			p.setStock(stock);
			p.setQuantity(quantity);
			p.setDiscount(discount);
		try {
			session.save(p);
			session.getTransaction().commit();
			System.out.println("Ubacen proizvod");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}
	
	
	
	
	
	
	
	
}
