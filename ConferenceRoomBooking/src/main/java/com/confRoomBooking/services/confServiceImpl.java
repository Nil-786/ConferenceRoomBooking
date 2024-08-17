package com.confRoomBooking.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.confRoomBooking.models.ConfPhotos;
import com.confRoomBooking.models.ConferenceRoom;

public interface confServiceImpl {
	
	public int addConf(ConferenceRoom confRoom);
	public void addPhoto(ConfPhotos photo);
	public List<ConferenceRoom> getAllConf();
	public byte[] readInputStream(InputStream inputStream) throws IOException;
}
