package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.dao.CustomerDao;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
	@Autowired
   	CustomerService customerService;
	
	@Autowired
   	CustomerDao customerDao;
	
	
	@GetMapping("/allCustomer")
	public List<Customer> getAllCustomer(){
		
		return customerService.findAllCustomer();
	}
	
	@GetMapping("/byFirstName/{firstName}")
	public List<Customer> findByFirstName(@PathVariable String firstName){
		
		return customerService.findByFirstName(firstName);
	}
	
	@GetMapping("/byLastName/{lastName}")
	public List<Customer> findByLastName(@PathVariable String lastName){
		
		return customerService.findByLastName(lastName);
	}
	
	
	@GetMapping("/byMobileNo/{mobileNumber}")
	public List<Customer> findByMobileNumber(@PathVariable String mobileNumber){
		
		return customerService.findByMobileNumber(mobileNumber);
	}
	
	
	
	@PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        // check if mobile number already exists in database
        if (customerService.existsByMobileNumber(customer.getMobileNumber())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Mobile number already present. Unable to create Customer");
        }

        // save the customer in the database if mobile number is not already existed in db.
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unable to create Customer. " + e.getMessage());
        }

        return ResponseEntity.ok("Customer account created successfully.");
    }
	
	
	
	
}
