package com.bookerapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.bookerapp.model.Customer;
import com.bookerapp.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;
	private List<Customer> updatedCustomerList;
	
	

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	// READ (BY ID)
	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}

	// READ (ALL)
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	// CREATE
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	// DELETE
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	// UPDATE
	public Customer updateCustomer(int customerId, Customer customer) {
		Customer updatedCustomer = customerRepository.findById(customerId).get();
		if (customer.getFirstName() != null) {
			updatedCustomer.setFirstName(customer.getFirstName());
		}
		if (customer.getLastName() != null) {
			updatedCustomer.setLastName(customer.getLastName());
		}
		return customerRepository.save(updatedCustomer);
	}

	// CREATE LIST
	public List<Customer> saveCustomerList(List<Customer> customerList) {
		return (List<Customer>) customerRepository.saveAll(customerList);
	}

	// DELETE LIST
	public void deleteCustomerList(List<Customer> customerList) {
		customerRepository.deleteAll(customerList);
	}
	

	// UPDATE LIST
	// NO UPDATE 
	// NULL POINTER
	@Transactional
	public List<Customer> updateCustomerList(List<Customer> customerList) {
		List<Customer> tempCustomer = new ArrayList<Customer>();
		for(Customer customer : customerList) {
			tempCustomer.add(updateCustomer(customer.getCustomerId(), customer));
		}
		return tempCustomer;
	}
}
