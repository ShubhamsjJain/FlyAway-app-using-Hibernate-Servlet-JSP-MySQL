package com.simplilearn.flyaway;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;







public class UserDAO {
	
	private SessionFactory factory;

	public UserDAO() {
		
		factory = HibernateUtil.getSessionFactory();
	}

	public void addNewUser(String e_mail, String password)throws Exception {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			//Check if the user entity  with the specified email already exists in the database
			
			Query q = session.createQuery("from User u where u.username = :name");
			q.setParameter("name",e_mail);
			User user = (User) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
			
			//If the user entity doesn't exist create a new one
			
			if(user == null) {
				user = new User();
				user.setUsername(e_mail);
				user.setPassword(password);
				session.save(user);
			}
			
			
			//Commit transaction
			
			transaction.commit();
			
		}catch(HibernateException e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		
	}

	public User verifyUser(String e_mail, String password)throws Exception {
		
		Session session = factory.openSession();
		
		try {
			
			//check whether user entity with that email and password exist or not 
			
			
		Query q = session.createQuery("from User u where u.username = :name AND u.password = :password"); 
		q.setParameter("name", e_mail);
		q.setParameter("password", password);
		User user_object = (User) q.uniqueResult();
		
		return user_object; 
		
		}finally {
			
			session.close();
		}
		
	}

	public void addNewAdmin(String e_mail, String password)throws Exception {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			//Check if the admin entity  with the specified email already exists in the database
			
			//Accessing admin table
			Query q = session.createQuery("from Admin a where a.e_mail = :name");
			q.setParameter("name",e_mail);
			Admin admin = (Admin) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
			
			//If the admin entity doesn't exist create a new one
			
			if(admin == null) {
				admin = new Admin();
				admin.setE_mail(e_mail);
				admin.setPassword(password);
				session.save(admin);
			}
			
			
			//Commit transaction
			
			transaction.commit();
			
		}catch(HibernateException e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		
	}

	public Admin verifyAdmin(String e_mail, String password)throws Exception {
		

		Session session = factory.openSession();
		
		try {
			
			//check whether admin entity with that email and password exist or not 
			
			
		Query q = session.createQuery("from Admin a where a.e_mail = :name AND a.password = :password"); 
		q.setParameter("name", e_mail);
		q.setParameter("password", password);
		Admin admin_object = (Admin) q.uniqueResult();
		
		return admin_object; 
		
		}finally {
			
			session.close();
		}
	}

	
	
	

}
