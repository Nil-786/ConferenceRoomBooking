package com.confRoomBooking.repositories;

import java.util.ArrayList;
import java.util.List;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.User;

public class ConferenceRoomRepo implements ConferenceRoomRepoImpl {
	Session sess;
	@Override
	public int addConf(ConferenceRoom conf) {
		// TODO Auto-generated method stub
		Integer id = 0;
		try {
			sess.beginTransaction();
			id = (Integer) sess.save(conf);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return id;
	}

	@Override
	public ConferenceRoom readConf(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConferenceRoom> readAllConf() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from ConferenceRoom");
			list = q.list();
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return list;
		
	}

	@Override
	public boolean updateConf(ConferenceRoom conf) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean deleteConf(int id) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("delete from ConferenceRoom where id=:conid");
			q.setParameter("conid", id);
			q.executeUpdate();
			sess.getTransaction().commit();
			deleted = true;
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return deleted;
	}

}
