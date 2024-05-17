package com.craft.service;

import com.craft.model.Customer;

public interface  CustomerService {
	void createCustomer(Customer customer);
    void updateCustomer(String customerId, Customer customer);
    Customer getCustomer(String customerId);
    void convertLeadToCustomer(String leadId);
}
