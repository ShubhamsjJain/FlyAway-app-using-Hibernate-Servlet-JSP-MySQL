package com.simplilearn.flyaway;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name="admin_id")
	private String e_mail;
	
	@Column(name="admin_password")
	private String password;

	public Admin() {
		
	}

	public Admin(int iD, String e_mail, String password) {
		
		ID = iD;
		this.e_mail = e_mail;
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", e_mail=" + e_mail + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
