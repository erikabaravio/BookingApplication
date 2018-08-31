package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer>{

}
