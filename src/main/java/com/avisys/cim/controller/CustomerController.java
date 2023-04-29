package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
	@Autowired
   	CustomerService customerService;
	
	
	@GetMapping("/allCustomer")
	public List<Customer> getAllCustomer(){
		
		return customerService.findAllCustomer();
	}
	
	@GetMapping("/byFirstName/{firstName}")
	public List<Customer> findByFirstNameIgnoreCase(@PathVariable String firstName){
		
		return customerService.findByFirstNameIgnoreCase(firstName);
	}
	
	@GetMapping("/byLastName/{lastName}")
	public List<Customer> findByLastNameIgnoreCase(@PathVariable String lastName){
		
		return customerService.findByLastNameIgnoreCase(lastName);
	}
	
	
	@GetMapping("/byMobileNo/{mobileNumber}")
	public List<Customer> findByMobileNumber(@PathVariable String mobileNumber){
		
		return customerService.findByMobileNumber(mobileNumber);
	}
	
	
	
	
	
}
