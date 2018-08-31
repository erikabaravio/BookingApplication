package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.ServiceFee;

@Repository
public interface ServiceFeeRepository extends CrudRepository<ServiceFee, Integer>{

}
