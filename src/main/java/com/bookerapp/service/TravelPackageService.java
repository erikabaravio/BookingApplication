package com.bookerapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.bookerapp.model.Customer;
import com.bookerapp.model.TravelPackage;
import com.bookerapp.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ServiceService serviceService;

public TravelPackageService(TravelPackageRepository travelPackageRepository, ServiceService serviceService) {
		super();
		this.travelPackageRepository = travelPackageRepository;
		this.serviceService = serviceService;
	}

//	@Transactional
//	public Customer saveCustomer(Customer customer) {
//		for(Feedback feedback:customer.getCustomerFeedback()) {
//			feedback.setCustomer(customer);
//			feedbackService.saveFeedback(feedback);
//		}
//		feedbackService.saveAllFeedback(customer.getCustomerFeedback());
//		throw new RuntimeException();
//		return customerRepository.save(customer);
//	}

//TRYING TO ADD SERVICE
	// CREATE LIST
	public List<TravelPackage> saveTravelPackageList(List<TravelPackage> travelPackageList ) {
		return (List<TravelPackage>) travelPackageRepository.saveAll(travelPackageList);
	}

	// DELETE LIST
	public void deleteTravelPackageList(List<TravelPackage> travelPackageList) {
		travelPackageRepository.deleteAll(travelPackageList);
	}

	// UPDATE LIST
	@Transactional
	public List<TravelPackage> updateTravelPackageList(List<TravelPackage> travelPackageList) {
		List<TravelPackage> tempTravelPackage = new ArrayList<TravelPackage>();
		for (TravelPackage travelPackage : travelPackageList) {
			tempTravelPackage.add(updateTravelPackage(travelPackage.getTravelPackageId(), travelPackage));
		}
		return tempTravelPackage;
	}

	// READ (ALL)
	public Iterable<TravelPackage> findAll() {
		return travelPackageRepository.findAll();
	}

//	//CREATE
//	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {
//		return travelPackageRepository.save(travelPackage);
//	}
//	
//	//READ (ALL)
//	public Iterable<TravelPackage> findAll(){
//		return travelPackageRepository.findAll();
//	}
//
//	//READ (BY ID)
//	public TravelPackage findById(int travelPackageId) {
//		return travelPackageRepository.findById(travelPackageId).get();
//	}
//	
//	//DELETE
//	public void deleteTravelPackage(TravelPackage travelPackage) {
//		travelPackageRepository.delete(travelPackage);
//	}
//
	// UPDATE
	public TravelPackage updateTravelPackage(int travelPackageId, TravelPackage travelPackage) {
		TravelPackage updatedTravelPackage = travelPackageRepository.findById(travelPackageId).get();
		if (travelPackage.getPackageName() != null) {
			updatedTravelPackage.setPackageName(travelPackage.getPackageName());
		}
		if (travelPackage.getDescription() != null) {
			updatedTravelPackage.setDescription(travelPackage.getDescription());
		}
		return travelPackageRepository.save(updatedTravelPackage);
	}

}
