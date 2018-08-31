package com.bookerapp.service;

import com.bookerapp.model.ServiceFee;
import com.bookerapp.repository.ServiceFeeRepository;

public class ServiceFeeService {

	private ServiceFeeRepository serviceFeeRepository;

	public ServiceFeeService(ServiceFeeRepository serviceFeeRepository) {
		super();
		this.serviceFeeRepository = serviceFeeRepository;
	}

	// READ (BY ID)
	public ServiceFee findById(int id) {
		return serviceFeeRepository.findById(id).get();
	}

	// READ (ALL)
	public Iterable<ServiceFee> findAll() {
		return serviceFeeRepository.findAll();
	}

	// CREATE
	public ServiceFee saveService(ServiceFee serviceFee) {
		return serviceFeeRepository.save(serviceFee);
	}

	// DELETE
	public void deleteServiceFee(ServiceFee serviceFee) {
		serviceFeeRepository.delete(serviceFee);
	}

	// UPDATE
	public ServiceFee updateServiceFee(int serviceFeeId, ServiceFee serviceFee) {
		ServiceFee updatedServiceFee = serviceFeeRepository.findById(serviceFeeId).get();
		if (serviceFee.getStartDate() != null) {
			updatedServiceFee.setStartDate(serviceFee.getStartDate());
		}
		return serviceFeeRepository.save(updatedServiceFee);
	}
}
