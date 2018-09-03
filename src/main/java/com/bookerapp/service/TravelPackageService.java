package com.bookerapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.bookerapp.model.TravelPackage;
import com.bookerapp.repository.TravelPackageRepository;


public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	
	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}

// LIST
	// CREATE LIST
	@Transactional
	public List<TravelPackage> saveTravelPackageList(List<TravelPackage> travelPackageList) {
		return (List<TravelPackage>) travelPackageRepository.saveAll(travelPackageList);
	}

	// READ LIST
	@Transactional
	public Iterable<TravelPackage> findAll() {
		return travelPackageRepository.findAll();
	}

	// DELETE LIST
	@Transactional
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

// BY ID	
	// UPDATE (BY ID)
	@Transactional
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

	// DELETE (BY ID)
	@Transactional
	public void deleteTravelPackage(TravelPackage travelPackage) {
		travelPackageRepository.delete(travelPackage);
	}

	/// READ (BY ID)
	@Transactional
	public TravelPackage findById(int travelPackageId) {
		return travelPackageRepository.findById(travelPackageId).get();
	}

}
