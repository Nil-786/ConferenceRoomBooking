package com.confRoomBooking.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.User;
import com.confRoomBooking.utilities.SessionGenerator;

public class ConferenceRoomRepo implements ConferenceRoomRepoImpl {
	Session sess;
	public ConferenceRoomRepo () {
		sess = new SessionGenerator().getSess();
	}
	
	
	@Override
	public int addConf(ConferenceRoom conf) {
		// TODO Auto-generated method stub
		Integer id = 0;
		try {
			sess.beginTransaction();
			id = (Integer) sess.save(conf);
			sess.getTransaction().commit();
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
	        }
		}finally {
			sess.close();
		}
		return id;
	}

	@Override
	public ConferenceRoom readConf(int id) {
		// TODO Auto-generated method stub
		ConferenceRoom croom = new ConferenceRoom();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from ConferenceRoom where id=:id");
			q.setParameter("id",id);
			croom =  (ConferenceRoom) q.list().get(0);
			sess.getTransaction().commit();
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
	        }
		}finally {
			sess.close();
		}
		
		return croom;

		
	}

	@Override
	public List<ConferenceRoom> readAllConf() {
		// TODO Auto-generated method stub
		List<ConferenceRoom> list = new ArrayList<>();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from ConferenceRoom");
			list = q.list();
			sess.getTransaction().commit();
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
	        }
		}finally {
			sess.close();
		}
		return list;
		
	}

	@Override
	public boolean updateConf(ConferenceRoom conf) {
		// TODO Auto-generated method stub
		boolean updated = false;
		try {
			sess.beginTransaction();
			sess.saveOrUpdate(conf);
			sess.getTransaction().commit();
			updated = true;
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
	        }
		}finally {
			sess.close();
		}
		return updated;
		
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
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
	        }
		}finally {
			sess.close();
		}
		return deleted;
	}
	
	

}
