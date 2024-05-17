package com.craft.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.craft.customermanagementservice.CustomerRepository;
import com.craft.dto.Leads;
import com.craft.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	public CustomerRepository customerRepository;
	@Autowired
	RestTemplate restTemplate;
	@Override
	public void createCustomer(Customer customer) {
		 String id = generateRandomId();
		 customer.setCustomerId(id);
		 customerRepository.save(customer);
		
	}
	public String generateRandomId() {
		Random random = new Random();
		String id;
		while(true) {
		 int randomNumber = random.nextInt(10000001);
		  id = "CUST" + randomNumber;
		 Optional<Customer> customerList =  customerRepository.findById(id);

		 if (customerList.isEmpty()) {
			 break;
		 }
		}
		 return id;
	}
	

	@Override
	public void updateCustomer(String customerId, Customer customer) {
		Customer customerDB = getCustomer(customerId);
		customerDB.setFirstName(customer.getFirstName());
		customerDB.setLastName(customer.getLastName());
		customerDB.setEmail(customer.getEmail());
		customerDB.setPhoneNumber(customer.getPhoneNumber());
		customerDB.setStreet(customer.getStreet());
		customerDB.setCity(customer.getCity());
		customerDB.setState(customer.getState());
		customerDB.setZipcode(customer.getZipcode());
		customerDB.setNotes(customer.getNotes());
		customerDB.setBirthday(customer.getBirthday());
		customerDB.setCompany(customer.getCompany());
		customerRepository.save(customerDB);
		
	}

	@Override
	public Customer getCustomer(String customerId) {
		 Optional<Customer> customerList =  customerRepository.findById(customerId);
		Customer customer =  customerList.get();
		return customer;
	}
	@Override
	public void convertLeadToCustomer(String leadId) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8081/leads/convert/" + leadId;
		restTemplate.getForObject(url, Leads.class);	
	}

}
