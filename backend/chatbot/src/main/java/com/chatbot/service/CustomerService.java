package com.chatbot.service;
import java.util.List;

import com.chatbot.exception.CustomerException;
import com.chatbot.model.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;

}
