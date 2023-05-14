package com.simplilearn.flyaway;



	
	import java.util.*;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
	import javax.persistence.Table;


	@Entity
	@Table(name="passenger_details")
	public class Passenger {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int ID;
		
		@Column(name="flight_num")
		private String flightNumber;
		
		@Column(name="firstName")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="phone_num")
		private long mobileNumber;
		
		@Column(name="noOfPerson")
		private int noOfPerson;
		
		@Column(name="aadhar_num")
		private String aadhar;
		
		@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
		private List<Payment> pay = new ArrayList<>();
		

		public Passenger() {
			
		}

		

		



		public Passenger(int iD, String flightNumber, String firstName, String lastName, long mobileNumber,
				int noOfPerson, String aadhar, List<Payment> pay, List<Flight> flights) {
			
			ID = iD;
			this.flightNumber = flightNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.mobileNumber = mobileNumber;
			this.noOfPerson = noOfPerson;
			this.aadhar = aadhar;
			this.pay = pay;
			
		}







		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public int getNoOfPerson() {
			return noOfPerson;
		}

		public void setNoOfPerson(int noOfPerson) {
			this.noOfPerson = noOfPerson;
		}

		public String getAadhar() {
			return aadhar;
		}

		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
		}



		public List<Payment> getPay() {
			return pay;
		}



		public void setPay(List<Payment> pay) {
			this.pay = pay;
		}

		
		
		
		

		
	

}
