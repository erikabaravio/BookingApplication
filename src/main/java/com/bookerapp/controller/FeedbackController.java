package com.bookerapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookerapp.model.Feedback;
import com.bookerapp.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

	private FeedbackService feedbackService;

	public FeedbackController(FeedbackService feedbackService) {
		super();
		this.feedbackService = feedbackService;
	}

	//READ (ALL)
	@GetMapping
	public Iterable<Feedback> getAllFeedback() {
		return feedbackService.findAll();
	}

	//CREATE
	@PostMapping
	public Feedback saveFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}

	//DELETE
	@DeleteMapping("/{feedbackId}")
	public void deleteFeedback(@PathVariable("feedbackId") int feedbackId) {
		feedbackService.deleteFeedback(feedbackService.findById(feedbackId));
	}

	//READ (BY ID)
	@GetMapping("/{feedbackId}")
	public Feedback findFeedback(@PathVariable("feedbackId") int feedbackId) {
		return feedbackService.findById(feedbackId);
	}
	
	//UPDATE
	@PutMapping("/{feedbackId}")
	public Feedback updateFeedback(@PathVariable("feedbackId") int feedbackId, @RequestBody Feedback feedback) {
		feedback.setFeedbackId(feedbackId);
		return feedbackService.updateFeedback(feedbackId, feedback);
	}

}
