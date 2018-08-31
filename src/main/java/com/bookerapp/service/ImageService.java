package com.bookerapp.service;

import com.bookerapp.model.Image;
import com.bookerapp.repository.ImageRepository;

public class ImageService {

	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	// READ (BY ID)
	public Image findById(int id) {
		return imageRepository.findById(id).get();
	}

	// READ (ALL)
	public Iterable<Image> findAll() {
		return imageRepository.findAll();
	}

	// CREATE
	public Image saveImage(Image image) {
		return imageRepository.save(image);
	}

	// DELETE
	public void deleteImage(Image image) {
		imageRepository.delete(image);
	}

	// UPDATE
	public Image updateImage(int imageId, Image image) {
		Image updatedImage = imageRepository.findById(imageId).get();
		if (image.getDescription() != null) {
			updatedImage.setDescription(image.getDescription());
		}
		if (image.getImageUrl() != null) {
			updatedImage.setImageUrl(image.getImageUrl());
		}
		
		return imageRepository.save(updatedImage);
	}
}
