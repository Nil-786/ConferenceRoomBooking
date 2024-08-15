package com.confRoomBooking.services;

import java.util.ArrayList;
import java.util.List;

import com.confRoomBooking.models.ConfPhotos;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.repositories.ConferenceRoomRepo;
import com.confRoomBooking.repositories.ConferenceRoomRepoImpl;

public class confService implements confServiceImpl{
	ConferenceRoomRepoImpl confRepo;
	private List<ConfPhotos> photos;

	public confService() {
		confRepo = new ConferenceRoomRepo();
		photos = new ArrayList<>();
	}
	@Override
	public int addConf(ConferenceRoom confRoom) {
		int id = confRepo.addConf(confRoom);
		return id;
	}
	@Override
	public void addPhoto(ConfPhotos photo) {
		photos.add(photo);
	}
	
	public List<ConfPhotos> getPhotos() {
		return photos;
	}
	public void setPhotos(List<ConfPhotos> photos) {
		this.photos = photos;
	}
	@Override
	public List<ConferenceRoom> getAllConf() {
		List<ConferenceRoom> confList = confRepo.readAllConf();
		return confList;
	}

}
