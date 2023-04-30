package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	
	
	
	
	
	
	
}
