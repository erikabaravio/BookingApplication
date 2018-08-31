package com.bookerapp.service;

import com.bookerapp.model.Feedback;
import com.bookerapp.repository.FeedbackRepository;

public class FeedbackService {

	private FeedbackRepository feedbackRepository;

	public FeedbackService(FeedbackRepository feedbackRepository) {
		super();
		this.feedbackRepository = feedbackRepository;
	}

	// READ (BY ID)
	public Feedback findById(int id) {
		return feedbackRepository.findById(id).get();
	}

	// READ (ALL)
	public Iterable<Feedback> findAll() {
		return feedbackRepository.findAll();
	}

	// CREATE
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	// DELETE
	public void deleteFeedback(Feedback feedback) {
		feedbackRepository.delete(feedback);
	}

	// UPDATE
	public Feedback updateFeedback(int feedbackId, Feedback feedback) {
		Feedback updatedFeedback = feedbackRepository.findById(feedbackId).get();
		if (feedback.getFeedback() != null) {
			updatedFeedback.setFeedback(feedback.getFeedback());
		}
		
		return feedbackRepository.save(updatedFeedback);
	}
}
