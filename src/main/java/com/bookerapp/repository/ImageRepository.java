package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer>{

}
