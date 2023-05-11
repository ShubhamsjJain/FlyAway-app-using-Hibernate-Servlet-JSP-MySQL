package com.simplilearn.flyaway;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FlightDAO {
	
	private SessionFactory factory;

	public FlightDAO() {
		
		factory = HibernateUtil.getSessionFactory();
	}

	public void addNewFlight(String flynum, String src, String dest, int seats, int duration, double price, Time arrival_time, Time departure_time, Date schedule_date) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			
			Flight fl = new Flight();
				
			fl.setFly_Num(flynum);
			fl.setSource(src);
			fl.setDestination(dest);
			fl.setSeats(seats);
			fl.setDuration(duration);
			fl.setPrice(price);
			fl.setArrival_time(arrival_time);
			fl.setDeparture_time(departure_time);
			fl.setSchedule(schedule_date);
			
			session.save(fl);
			
			
			
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

	
	}

	
	
	
	


