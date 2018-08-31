package com.bookerapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	// READ (ALL)
	@GetMapping
	public Iterable<TravelPackage> getAllTravelPackage() {
		return travelPackageService.findAll();
	}

	// CREATE
	@PostMapping
	public TravelPackage saveTravelPackage(@RequestBody TravelPackage travelPackage) {
		return travelPackageService.saveTravelPackage(travelPackage);
	}

	// DELETE
	@DeleteMapping("/{travelPackageId}")
	public void deleteTravelPackage(@PathVariable("travelPackageId") int travelPackageId) {
		travelPackageService.deleteTravelPackage(travelPackageService.findById(travelPackageId));
	}

	// READ (BY ID)
	@GetMapping("/{travelPackageId}")
	public TravelPackage findTravelPackage(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findById(travelPackageId);
	}

	// UPDATE
	@PutMapping("/{travelPackageId}")
	public TravelPackage updateTravelPackage(@PathVariable("travelPackageId") int travelPackageId, @RequestBody TravelPackage travelPackage) {
		travelPackage.setTravelPackageId(travelPackageId);
		return travelPackageService.updateTravelPackage(travelPackageId, travelPackage);
	}
}
