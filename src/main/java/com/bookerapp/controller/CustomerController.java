package com.bookerapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookerapp.model.Customer;
import com.bookerapp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	// DELETE (BY ID)
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerService.findById(customerId));
	}

	// READ (BY ID)
	@GetMapping("/{customerId}")
	public Customer findCustomer(@PathVariable("customerId") int customerId) {
		return customerService.findById(customerId);
	}

	// UPDATE (BY ID)
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		return customerService.updateCustomer(customerId, customer);
	}

//-----------------

	// READ LIST
	@GetMapping
	public Iterable<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	// CREATE LIST
	@PostMapping
	public List<Customer> saveCustomerList(@RequestBody List<Customer> customerList) {
		return customerService.saveCustomerList(customerList);
	}

	// DELETE LIST
	@DeleteMapping
	public void deleteCustomerList() {
		customerService.deleteCustomerList((List<Customer>) customerService.findAll());
	}

	// UPDATE LIST
	@PutMapping
	public List<Customer> updateCustomerList(@RequestBody List<Customer> customerList) {
		return customerService.updateCustomerList(customerList);
	}

}
