package com.avisys.cim.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avisys.cim.Customer;


public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	List<Customer> findByFirstNameIgnoreCase(String firstName);
	
	List<Customer> findByLastNameIgnoreCase(String lastName);

	List<Customer> findByMobileNumber(String mobileNumber);
}
