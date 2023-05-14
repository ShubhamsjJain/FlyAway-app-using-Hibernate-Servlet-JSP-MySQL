package com.simplilearn.flyaway;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class FlightDAO {
	
	private SessionFactory factory;

	public FlightDAO() {
		
		factory = HibernateUtil.getSessionFactory();
	}

	public void addNewFlight(String flynum, String src, String dest, int seats, int duration, double price, Time departure_time, Time arrival_time, Date schedule_date) {
		
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
			fl.setDeparture_time(departure_time);
			fl.setArrival_time(arrival_time);
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

	public List<Flight> listAllFlights()throws Exception {
		
        Session session = factory.openSession();
		
		try {
			
		List<Flight> list = session.createQuery("from Flight").list(); 
		
		return list; 
		
		}finally {
			
			session.close();
		}
	}

	public Flight getFlightObject(String flynum)throws Exception {
		
        Session session = factory.openSession();
		
		try {
			
			Query q = session.createQuery("from Flight f where f.fly_Num = :name");
			q.setParameter("name",flynum);
			Flight flight = (Flight) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
		
		    return flight; 
		
		}finally {
			
			session.close();
		}
		
	}

	public void updateFlight(String flynum, String src, String dest, int seats, int duration, double price,
			Time departure_time, Time arrival_time, Date schedule_date) {
		
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			
			String hql = "UPDATE Flight SET source=:source,destination=:destination,arrival_time=:arrival_time,"
					+ "departure_time=:departure_time,schedule=:schedule,seats=:seats,duration=:duration,price=:price WHERE fly_Num=:fly_Num";
			Query query1 = session.createQuery(hql);
			
			query1.setParameter("fly_Num",flynum);
			query1.setParameter("source",src);
			query1.setParameter("destination",dest);
			query1.setParameter("arrival_time",arrival_time);
			query1.setParameter("departure_time",departure_time);
			query1.setParameter("schedule",schedule_date);
			query1.setParameter("seats",seats);
			query1.setParameter("duration",duration);
			query1.setParameter("price",price);
			
			
			query1.executeUpdate();
				
			
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

	public void deleteFlight(String flynum)throws Exception {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Query query1 = session.createQuery("from Flight f where f.fly_Num= :name");
			
			query1.setParameter("name",flynum);
			
			Flight flight = (Flight) query1.uniqueResult(); 
			
			session.delete(flight);
				
			
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

	public List<Flight> searchFlight(String src, String des, Date schedule_date)throws Exception {
		
		
        Session session = factory.openSession();
		
		try {
			
			String hql = "FROM Flight WHERE source=:source1 and destination=:dest and schedule=:schdate";
			Query query = session.createQuery(hql);
			
			
		    query.setParameter("source1", src);
			query.setParameter("dest", des);
			query.setParameter("schdate", schedule_date);
			
			
			List<Flight> flights = query.list();
			
			return flights;
			
		
		
		}finally {
			
			session.close();
		}
	}

	public void updateSeatsInFlight(Passenger passenger)throws Exception {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			String flight_num = passenger.getFlightNumber();
			int num_of_passengers = passenger.getNoOfPerson();
			
			Query query1 = session.createQuery("from Flight f where f.fly_Num= :name");	
			query1.setParameter("name",flight_num);		
			Flight flight = (Flight) query1.uniqueResult(); 
			
			int total_seats_available = flight.getSeats();
			int updated_seats = (total_seats_available - num_of_passengers);
			
			
			//Update flight

			Query q = session.createQuery("UPDATE Flight SET seats=:seats WHERE fly_Num=:flyNum");
			
			q.setParameter("seats", updated_seats);
			q.setParameter("flyNum", flight_num);
			
			q.executeUpdate();
				
			
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

	
	
	
	


