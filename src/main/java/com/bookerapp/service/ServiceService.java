package com.bookerapp.service;

import com.bookerapp.model.Service;
import com.bookerapp.repository.ServiceRepository;

public class ServiceService {
	
	private ServiceRepository serviceRepository;

	public ServiceService(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	// READ (BY ID)
	public Service findById(int id) {
		return serviceRepository.findById(id).get();
	}

	// READ (ALL)
	public Iterable<Service> findAll() {
		return serviceRepository.findAll();
	}

	// CREATE
	public Service saveService(Service service) {
		return serviceRepository.save(service);
	}

	// DELETE
	public void deleteService(Service service) {
		serviceRepository.delete(service);
	}

	// UPDATE
	public Service updateService(int serviceId, Service service) {
		Service updatedService = serviceRepository.findById(serviceId).get();
		if (service.getServiceName() != null) {
			updatedService.setServiceName(service.getServiceName());
		}
		if (service.getDescription() != null) {
			updatedService.setDescription(service.getDescription());
		}
		return serviceRepository.save(updatedService);
	}
}
