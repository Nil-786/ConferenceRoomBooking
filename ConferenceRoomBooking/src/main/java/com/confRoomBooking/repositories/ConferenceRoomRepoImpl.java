package com.confRoomBooking.repositories;

import java.util.List;

import com.confRoomBooking.models.ConferenceRoom;

public interface ConferenceRoomRepoImpl {
	public int addConf(ConferenceRoom conf) ;
	public ConferenceRoom readConf(int id);
	public List<ConferenceRoom> readAllConf();
	public boolean updateConf(ConferenceRoom conf);
	public boolean deleteConf(int id);
}
