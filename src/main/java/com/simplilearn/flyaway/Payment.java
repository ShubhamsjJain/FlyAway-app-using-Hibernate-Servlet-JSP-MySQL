package com.simplilearn.flyaway;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="payment_info")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name="card_num")
	private String cardNumber;
	
	@Column(name="card_holder_name")
	private String cardHolderName;
	
	@Column(name="cvv")
	private String cvv;
	
	@Column(name="month")
	private String month;
	
	@Column(name="year")
	private String year;
	
	@Column(name="paid_date")
	private Date paidDate;
	
	@Column(name="paid_amount")
	private double paidAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)//FetchType Eager to prevent lazy loading exception which occurs generally in bidirectional mapping
	@JoinColumn(name="passenger_id")
	private Passenger passenger;

	public Payment() {
		
	}

	public Payment(int iD, String cardNumber, String cardHolderName, String cvv, String month, String year,
			Date paidDate, double paidAmount, Passenger passenger) {
		
		ID = iD;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.month = month;
		this.year = year;
		this.paidDate = paidDate;
		this.paidAmount = paidAmount;
		this.passenger = passenger;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	} 
	
	
	
	

}
