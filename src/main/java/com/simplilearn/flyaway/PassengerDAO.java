package com.simplilearn.flyaway;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class PassengerDAO {
	
	private SessionFactory factory;

	public PassengerDAO() {
		
		factory = HibernateUtil.getSessionFactory();
		
	}

	public Passenger addPassenger(String flyno, String firstname, String lastname, Long phoNo, Integer noOfPerson,
			String aadhar)throws Exception {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			
			//Check if the passenger entity  with the specified aadhar number already exists in the database
			
			Query q = session.createQuery("from Passenger p where p.aadhar = :name");
			q.setParameter("name",aadhar);
			Passenger passenger = (Passenger) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
			
			//If the passenger entity doesn't exist create a new one
			
			if(passenger == null) {
				passenger = new Passenger();
				passenger.setFlightNumber(flyno);
				passenger.setFirstName(firstname);
				passenger.setLastName(lastname);
				passenger.setMobileNumber(phoNo);
				passenger.setNoOfPerson(noOfPerson);
				passenger.setAadhar(aadhar);
				session.save(passenger);
			}
			
			
			//Commit transaction
			
			transaction.commit();
			
			
			return passenger;
			
		}finally {
			
			session.close();
		}
	}
	
	

}
