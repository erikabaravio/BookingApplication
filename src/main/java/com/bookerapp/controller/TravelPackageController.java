package com.bookerapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookerapp.model.Customer;
import com.bookerapp.model.TravelPackage;
import com.bookerapp.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	private TravelPackageService travelPackageService;
	
	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}

	// DELETE (BY ID)
	@DeleteMapping("/{travelPackageId}")
	public void deleteTravelPackage(@PathVariable("travelPackageId") int travelPackageId) {
		travelPackageService.deleteTravelPackage(travelPackageService.findById(travelPackageId));
	}

	// READ (BY ID)
	@GetMapping("/{travelPackageId}")
	public TravelPackage findTravelPackage(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findById(travelPackageId);
	}

	// UPDATE (BY ID)
	@PutMapping("/{travelPackageId}")
	public TravelPackage updateTravelPackage(@PathVariable("travelPackageId") int travelPackageId, @RequestBody TravelPackage travelPackage) {
		travelPackage.setTravelPackageId(travelPackageId);
		return travelPackageService.updateTravelPackage(travelPackageId, travelPackage);
	}

//-----------------

	// READ LIST
	@GetMapping
	public Iterable<TravelPackage> getAllTravelPackage() {
		return travelPackageService.findAll();
	}

	// CREATE LIST
	@PostMapping
	public List<TravelPackage> saveTravelPackageList(@RequestBody List<TravelPackage> travelPackageList) {
		return travelPackageService.saveTravelPackageList(travelPackageList);
	}

	// DELETE LIST
	@DeleteMapping
	public void deleteTravelPackageList() {
		travelPackageService.deleteTravelPackageList((List<TravelPackage>) travelPackageService.findAll());
	}

	// UPDATE LIST
	@PutMapping
	public List<TravelPackage> updateCustomerList(@RequestBody List<TravelPackage> travelPackageList) {
		return travelPackageService.updateTravelPackageList(travelPackageList);
	}

}
