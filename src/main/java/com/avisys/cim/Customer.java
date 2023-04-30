package com.avisys.cim;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//@SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 5 )
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@OneToMany(mappedBy = "mobileCustomer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<MobileNumber> MobNumbers = new ArrayList<MobileNumber>(); //init empty list
	
	public void addNo(MobileNumber mobNo) {
		MobNumbers.add(mobNo);
		mobNo.setMobileCustomer(this);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public List<MobileNumber> getMobNumbers() {
		return MobNumbers;
	}



}
