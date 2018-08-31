package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}
