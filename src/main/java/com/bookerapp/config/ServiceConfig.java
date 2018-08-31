package com.bookerapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookerapp.model.Service;
import com.bookerapp.model.TravelPackage;
import com.bookerapp.repository.CustomerRepository;
import com.bookerapp.repository.FeedbackRepository;
import com.bookerapp.repository.ReservationRepository;
import com.bookerapp.repository.ServiceRepository;
import com.bookerapp.repository.TravelPackageRepository;
import com.bookerapp.service.CustomerService;
import com.bookerapp.service.FeedbackService;
import com.bookerapp.service.ReservationService;
import com.bookerapp.service.ServiceService;
import com.bookerapp.service.TravelPackageService;


@Configuration
public class ServiceConfig {
	
	@Bean
	public CustomerService customerService(CustomerRepository customerRepository) {
		return new CustomerService(customerRepository);
	}
	
	@Bean
	public FeedbackService feedbackService(FeedbackRepository feedbackRepository) {
		return new FeedbackService(feedbackRepository);
	}
	
	@Bean
	public ReservationService reservationService(ReservationRepository reservationRepository) {
		return new ReservationService(reservationRepository);
	}
	
	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository, ServiceService serviceService) {
		return new TravelPackageService(travelPackageRepository, serviceService);
	}
	
	@Bean
	public ServiceService serviceService(ServiceRepository serviceRepository) {
		return new ServiceService(serviceRepository);
	}
}
