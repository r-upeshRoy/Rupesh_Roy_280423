package com.avisys.cim.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avisys.cim.Customer;


public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
	
	List<Customer> findByLastNameContainingIgnoreCase(String lastName);

	List<Customer> findByMobileNumber(String mobileNumber);

	boolean existsByMobileNumber(String mobileNumber);
}
