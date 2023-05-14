package com.simplilearn.flyaway;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PaymentDAO {
	
	private SessionFactory factory;
	
	

	public PaymentDAO() {
		
		factory = HibernateUtil.getSessionFactory();
	}



	public Payment addPayment(String cardNo, String cardHolderName, String mM, String yYYY, String cVV, Double paidAmt,
			Date schedule_paid_date, int passenger_id)throws Exception {
		
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			
			//Find Passenger object w.r.t given passenger id
			
			Query q = session.createQuery("from Passenger p where p.ID = :name");
			q.setParameter("name",passenger_id);
			Passenger passenger = (Passenger) q.uniqueResult(); 
			
			//Saving payment details and also associating passenger with payment
			
				Payment payment = new Payment();
				payment.setCardNumber(cardNo);
				payment.setCardHolderName(cardHolderName);
				payment.setMonth(mM);
				payment.setYear(yYYY);
				payment.setCvv(cVV);
				payment.setPaidAmount(paidAmt);
				payment.setPaidDate(schedule_paid_date);
				payment.setPassenger(passenger);
				
				session.save(payment);
				
			//Commit transaction
			
			transaction.commit();
			
			return payment;
			
		}finally {
			
			session.close();
		}
	}

}
