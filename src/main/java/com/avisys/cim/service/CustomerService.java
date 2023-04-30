package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.dao.CustomerDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
  
	@Autowired
    CustomerDao customerDao;
	
	
	public List<Customer> findAllCustomer(){
		return customerDao.findAll();
	}
	
	public List<Customer> findByFirstName(String firstName){
		
		return customerDao.findByFirstNameContainingIgnoreCase(firstName);
	}
	

	public List<Customer> findByLastName(String lastName){
		return customerDao.findByLastNameContainingIgnoreCase(lastName);	
	}

	public List<Customer> findByMobileNumber(String mobileNumber) {
				return customerDao.findByMobileNumber(mobileNumber);
	}

	public boolean existsByMobileNumber(String mobileNumber) {
		
		return customerDao.existsByMobileNumber(mobileNumber);
	}

	

}
