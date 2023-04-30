package com.avisys.cim;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mobile_number")
public class MobileNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Mob_number", nullable = false)
	private String mobileNumber;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Customer mobileCustomer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Customer getMobileCustomer() {
		return mobileCustomer;
	}

	public void setMobileCustomer(Customer mobileCustomer) {
		this.mobileCustomer = mobileCustomer;
	}
	
	
	
}
