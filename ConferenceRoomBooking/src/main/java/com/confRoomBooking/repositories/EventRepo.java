package com.confRoomBooking.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;
import com.confRoomBooking.utilities.SessionGenerator;

public class EventRepo implements EventRepoImpl {

	Session sess;
	public EventRepo() {
		sess = new SessionGenerator().getSess();
	}
	@Override
	public int addEvent(Event event) {
		Integer id = 0;
		try {
			sess.beginTransaction();
			id = (Integer) sess.save(event);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return id;

	}

	@Override
	public Event readEvent(int id) {
		Event event = new Event();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from Event where id = "+id);
			event =  (Event) q.list().get(0);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		
		return event;
	}

	@Override
	public List<Event> readAllEvent() {
		List<Event> list = new ArrayList<>();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from Event");
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
	public boolean updateEvent(Event event) {
		boolean updated = false;
		try {
			sess.beginTransaction();
			sess.saveOrUpdate(event);
			sess.getTransaction().commit();
			updated = true;
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return updated;
	}

	@Override
	public boolean deleteEvent(int id) {
		boolean deleted = false;
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("delete from Event where id=:eventid");
			q.setParameter("eventid", id);
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
	
	public List<Event> readEventByConf(ConferenceRoom conf) {
		List<Event> list = new ArrayList<>();
		
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from Event where conf_room_id=:confg");
			q.setParameter("confg",conf);
			list = q.list();
		} catch(Exception e) {
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return list;
	}

}
