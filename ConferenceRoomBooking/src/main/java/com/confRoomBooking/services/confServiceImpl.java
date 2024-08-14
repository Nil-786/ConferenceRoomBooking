package com.confRoomBooking.services;

import com.confRoomBooking.models.ConfPhotos;
import com.confRoomBooking.models.ConferenceRoom;

public interface confServiceImpl {
	
	public int addConf(ConferenceRoom confRoom);
	public void addPhoto(ConfPhotos photo);
}
