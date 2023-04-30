package com.avisys.cim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.MobileNumber;
import com.avisys.cim.dao.CustomerDao;
import com.avisys.cim.dao.MobileDao;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
  
	@Autowired
    CustomerDao customerDao;
	
	@Autowired
    MobileDao mobileDao;
	
	public List<Customer> findAllCustomer(){
		return customerDao.findAll();
	}
	
	public List<Customer> findByFirstName(String firstName){
		
		return customerDao.findByFirstNameContainingIgnoreCase(firstName);
	}

	public List<Customer> findByLastName(String lastName){
		return customerDao.findByLastNameContainingIgnoreCase(lastName);	
	}
	

	// adding multiple mobile Number for customer
    public String addNo(Long id, MobileNumber mob) {
		Customer customer=customerDao.findById(id).get();
		customer.addNo(mob);
		mobileDao.save(mob);		
		return "successfully Added Number";
	}
	

    //Method for get  Multiple Mobile Number for single Customer
    public List<MobileNumber> getAll(Long customerId) {
        Optional<Customer> customer = customerDao.findById(customerId);
        if (customer.isPresent()) {
          return customer.get().getMobNumbers();
        } else {
          throw new EntityNotFoundException("Customer with id " + customerId + " not found.");
        }
      }


    //Method for getting All Customer Details by Mobile Number 
	public Customer getCustomerByMobNo(String mobileNumber) {
		List<MobileNumber> mobNo = mobileDao.findAll();
		
		for (MobileNumber mobileNum : mobNo) {
			if(mobileNum.getMobileNumber().equals(mobileNumber))
			   return mobileNum.getMobileCustomer();
		}
		return null;
	}
	
	//Method for creating Customer Account
	public ResponseEntity<String> createCustomer(Customer customer,String mobNo) {	
		List<MobileNumber> mobi=mobileDao.findAll();
		for(MobileNumber mob:mobi) {
			if(mob.getMobileNumber().equals(mobNo)) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("already exists");
			}
		}
		customerDao.save(customer);
		return ResponseEntity.ok("Custmer addded Successfully");	
		
	}
	
	//Method for deleting Customer Details
	public ResponseEntity<String> deleteCustomer(String mobileNo) {
		List<MobileNumber> mobile = mobileDao.findAll();// getting all Mobile NUmbers.
		for (MobileNumber m : mobile) {
			if (m.getMobileNumber().equals(mobileNo)) {
				customerDao.delete(m.getMobileCustomer());//checking Mobile Number exists in database or not.
				return ResponseEntity.ok("Customer Details deleted Successfully");
			}
		}
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("mobile number is not exists");
	}
	
	
	
	public String addCustomerNumber(Long id, MobileNumber mobile) {
		try {
			Customer customer = customerDao.findById(id).get();
			customer.addNo(mobile);// this is helper method to add mobile object in list and set the
								// customer to the mobile number
			mobileDao.save(mobile);
			return "mobile number added successful";

		} catch (Exception e) {
			return "Invalid Id";
		}
	}
	
	
	public String deleteCustomerNumber(Long id, MobileNumber mobNo) {
		try {
			Customer customer = customerDao.findById(id).get();
			List<MobileNumber> mobile = customer.getMobNumbers();
			
			for(MobileNumber m:  mobile) {
				if(m.getMobileNumber().equals(mobNo.getMobileNumber())) {
					customer.deleteNumber(m);
					mobileDao.delete(m);
					return "Customer Mobile number deleted successful";
				}
			}
			return "Invalid Mobile Number";	
		} catch (Exception e) {
			return "Invalid Id";
		}
	}
    
   

}
