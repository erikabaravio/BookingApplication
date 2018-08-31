package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.Customer;

@Repository
	public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
