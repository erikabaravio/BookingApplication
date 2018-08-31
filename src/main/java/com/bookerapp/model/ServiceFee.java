package com.bookerapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@JsonIdentityInfo(generator=PropertyGenerator.class, property="serviceFeeId")
@Entity
public class ServiceFee {
	@Id
	private int serviceFeeId;
	private float amount;
	@ManyToOne
	private Service service;
	private LocalDate startDate;
	
	
	public int getServiceFeeId() {
		return serviceFeeId;
	}
	public void setServiceFeeId(int serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}
