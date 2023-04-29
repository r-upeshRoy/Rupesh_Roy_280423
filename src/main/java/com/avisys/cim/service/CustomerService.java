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
	
	public List<Customer> findByFirstNameIgnoreCase(String firstName){
		
		return customerDao.findByFirstNameIgnoreCase(firstName);
	}
	

	public List<Customer> findByLastNameIgnoreCase(String lastName){
		return customerDao.findByLastNameIgnoreCase(lastName);	
	}

	public List<Customer> findByMobileNumber(String mobileNumber) {
				return customerDao.findByMobileNumber(mobileNumber);
	}
	
	
	
	

}
