package com.bookerapp.service;

import com.bookerapp.model.TravelPackage;
import com.bookerapp.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	
	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}

	//CREATE
	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {
		return travelPackageRepository.save(travelPackage);
	}
	
	//READ (ALL)
	public Iterable<TravelPackage> findAll(){
		return travelPackageRepository.findAll();
	}

	//READ (BY ID)
	public TravelPackage findById(int travelPackageId) {
		return travelPackageRepository.findById(travelPackageId).get();
	}
	
	//DELETE
	public void deleteTravelPackage(TravelPackage travelPackage) {
		travelPackageRepository.delete(travelPackage);
	}

	//UPDATE
	public TravelPackage updateTravelPackage(int travelPackageId, TravelPackage travelPackage) {
		TravelPackage updatedTravelPackage = travelPackageRepository.findById(travelPackageId).get();
		if(travelPackage.getPackageName()!= null) {
			updatedTravelPackage.setPackageName(travelPackage.getPackageName());
		}
		if(travelPackage.getDescription()!= null) {
			updatedTravelPackage.setDescription(travelPackage.getDescription());
		}
		return travelPackageRepository.save(updatedTravelPackage);
	}

}
