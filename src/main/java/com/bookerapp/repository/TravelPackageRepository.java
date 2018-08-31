package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.TravelPackage;

@Repository
public interface TravelPackageRepository extends CrudRepository<TravelPackage, Integer>{

}
