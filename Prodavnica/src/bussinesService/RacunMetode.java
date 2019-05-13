package bussinesService;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Bill;
import model.Product;
import model.User;

public class RacunMetode {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public List<String> izbaciNuleIzQuantitija(String[] quantity){
		List<String> listaQuantitija = new ArrayList<String>();
		
		for(int i = 0 ; i<quantity.length ; i++) {
			if(!(quantity[i].equals("0"))) {
				listaQuantitija.add(quantity[i]);
			}
		}
		return listaQuantitija;
	}
	
	
	public Product vratiProduct(String id) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Product p = new Product();

		try {
			p = session.get(Product.class, Integer.parseInt(id));//ovo je select iz baze
			session.getTransaction().commit();
			return p;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}
	
	public List<Product> listOfProduct(String[]nizIdProizvoda, List<String>listaQuantitija){
		
		List<Product>listOfProduct = new ArrayList<Product>();
		Product product = new Product();
		
		for(int i = 0; i<listaQuantitija.size();i++) {
			product = vratiProduct(nizIdProizvoda[i]);
			product.setQuantity(Integer.parseInt(listaQuantitija.get(i)));
			listOfProduct.add(product);
		}
		return listOfProduct;
		
	}
	
	
	public Bill upisiRacunUBazu(int idUser, List<Product>listOfProduct) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Bill bill = new Bill();
		User user = new User();
		double total = 0;
		try {
			user = session.get(User.class, idUser );//ovo je select iz baze
			bill.setUser(user);
			bill.setListOfProducts(listOfProduct);
			for(Product p: listOfProduct) {
				
				total += (p.getPrice()*p.getQuantity())*(100-p.getDiscount())/100;
			}
			bill.setTotalPrice(total);
			
			session.save(bill);
			session.getTransaction().commit();
			return bill;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
		
		
		
	}
	
}
