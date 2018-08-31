package com.bookerapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bookerapp.repository.CustomerRepository;
import com.bookerapp.repository.FeedbackRepository;
import com.bookerapp.repository.ReservationRepository;
import com.bookerapp.repository.TravelPackageRepository;
import com.bookerapp.service.CustomerService;
import com.bookerapp.service.FeedbackService;
import com.bookerapp.service.ReservationService;
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
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository) {
		return new TravelPackageService(travelPackageRepository);
	}
}
