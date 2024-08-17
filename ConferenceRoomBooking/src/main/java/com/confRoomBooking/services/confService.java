package com.confRoomBooking.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
	
	public ConferenceRoom getConf(int id) {
		return confRepo.readConf(id);
	}
	
	public void setPhotos(List<ConfPhotos> photos) {
		this.photos = photos;
	}
	@Override
	public List<ConferenceRoom> getAllConf() {
		List<ConferenceRoom> confList = confRepo.readAllConf();
		return confList;
	}
	@Override
	public byte[] readInputStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int bytesRead;
		while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, bytesRead);
		}
		return buffer.toByteArray();
	}

}
