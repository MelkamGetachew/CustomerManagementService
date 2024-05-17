
package com.craft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.model.Customer;
import com.craft.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") String customerId, @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/convert/{leadId}")
    public ResponseEntity<?>  convertLeadToCustomer(@PathVariable("leadId") String leadId) {
    	customerService.convertLeadToCustomer(leadId);
    	 return new ResponseEntity<>("Lead converted to customer successfully", HttpStatus.OK);
       
    }
}
