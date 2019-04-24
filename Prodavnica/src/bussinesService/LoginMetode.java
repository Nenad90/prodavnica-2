package bussinesService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginMetode {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	
	
	public boolean daLiPostojiUser(String userName) {
		
		List<User> listOfUsers = new ArrayList<User>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("FROM User WHERE userName = :pera");
			query.setParameter("pera", userName);
		
			listOfUsers = query.getResultList();
			
			if(listOfUsers.size()==1) {
				session.getTransaction().commit();
				System.out.println("Postoji user name");
				return true;
			}else {
				session.getTransaction().commit();
				System.out.println("Nepostoji user name");
				return false;
			}
			
		}catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Neuspela transakcija");
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
	public boolean daLiJeDobarPassword(String userName, String password) {
		 
		List<String> listOfPasswords = new ArrayList<String>();
		boolean b = true;
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("SELECT password FROM User WHERE userName = :pera");
			query.setParameter("pera", userName);
		
			listOfPasswords = query.getResultList();
			
			for(String s:listOfPasswords) {
				if(s.equals(password)) {
					b = true;
					System.out.println("OK pass");
				}else {
					System.out.println("NIJE OK pass");
					b = false;
				}
			}
			session.getTransaction().commit();
			return b;
		}catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Neuspela transakcija");
			return false;
		}finally {
			session.close();
		}
	}
	
	public User vratiUsera(String userName,String password) {
		
		List<User> listOfUsers = new ArrayList<User>();
		User user = null;
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String hql = "FROM User WHERE userName = :x AND password = :y";
			Query query = session.createQuery(hql);
				query.setParameter("x", userName);
				query.setParameter("y", password);
			
			listOfUsers = query.getResultList();
			
				if(listOfUsers.size() != 0) {
					user = listOfUsers.get(0);
				}else {
					user = null;
				}
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	
}
