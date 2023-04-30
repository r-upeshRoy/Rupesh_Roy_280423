package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.cim.Customer;
import com.avisys.cim.MobileNumber;
import com.avisys.cim.dao.MobileDao;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
	@Autowired
   	CustomerService customerService;
		
	@Autowired
   	MobileDao mobileDao;
	
	
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
	
	@PostMapping("/addMobile/{id}")  
	public String addmobile(@PathVariable Long id,@RequestBody MobileNumber mob) {
		return customerService.addNo(id,mob);
	}
	
	@GetMapping("/getMobileNoById/{id}")
	public List<MobileNumber> getAllMobileNumber(@PathVariable Long id){
			return customerService.getAll(id);
	}
	
	@GetMapping("/getCustomerByMobNo/{mobileNumber}")
	public Customer getCustomerByMobNo(@PathVariable String mobileNumber){
		  
			return customerService.getCustomerByMobNo(mobileNumber);
	}
	
	
	@PostMapping("/addCustomer/{mobileNo}")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer,@PathVariable String mobileNo){
		return customerService.createCustomer(customer,mobileNo);
	}

	
	@DeleteMapping("/deleteCustomer/{mobileNo}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String mobileNo){
		return customerService.deleteCustomer(mobileNo);
	}
	
	
	// Method for Adding multiple Customer Mobile number to existing customer
	@PostMapping("/addCustomerNumber/{id}")
	public String addCustomerNumber(@PathVariable Long id, @RequestBody MobileNumber mob) {
		return customerService.addCustomerNumber(id, mob);
	}

	// Method for deleting multiple Customer Mobile number to existing customer
	@PostMapping("/deleteMobileNo/{id}")
	public String deleteMobileNo(@PathVariable Long id, @RequestBody MobileNumber mob) {
		return customerService.deleteCustomerNumber(id, mob);
	}
	
	


	
	
	
	
	
	
	
	
}
