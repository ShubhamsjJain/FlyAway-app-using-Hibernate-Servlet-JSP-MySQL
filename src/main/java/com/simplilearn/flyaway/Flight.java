package com.simplilearn.flyaway;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="flight_details")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name="flight_num")
	private String fly_Num;
	
	@Column(name="src")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="seats")
	private int seats;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="price")
	private double price;
	
	@Column(name="arrival_time")
	private Time arrival_time;
	
	@Column(name="departure_time")
	private Time departure_time;
	
	@Column(name="schedule")
	private Date schedule;
	
	

	public Flight() {
		
	}


	


	public Flight(int iD, String fly_Num, String source, String destination, int seats, int duration, double price,
			Time arrival_time, Time departure_time, Date schedule, List<Passenger> passengers) {
		
		ID = iD;
		this.fly_Num = fly_Num;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
		this.duration = duration;
		this.price = price;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.schedule = schedule;
		
	}





	public Flight(String source, String destination, Date schedule) {
		super();
		this.source = source;
		this.destination = destination;
		this.schedule = schedule;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getFly_Num() {
		return fly_Num;
	}


	public void setFly_Num(String fly_Num) {
		this.fly_Num = fly_Num;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Time getArrival_time() {
		return arrival_time;
	}


	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}


	public Time getDeparture_time() {
		return departure_time;
	}


	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}


	public Date getSchedule() {
		return schedule;
	}


	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	
	
	
	
	

	
}
