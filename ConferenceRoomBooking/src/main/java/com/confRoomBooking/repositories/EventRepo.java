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
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
			}
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
		}
		return id;

	}

	@Override
	public Event readEvent(int id) {
		Event event = new Event();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from Event where id = " + id);
			event = (Event) q.list().get(0);
			sess.getTransaction().commit();
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
			}
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
		}

		return event;
	}

	@Override
	public List<Event> readAllEvent() {
		List<Event> list = new ArrayList<>();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery(
					"select e.conferenceRoom.id, e.username ,e.start ,e.end, e.title, e.empCode from Event e");
			list = q.list();
			sess.getTransaction().commit();
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
			}
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
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
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
			}
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
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
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
			}
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
		}

		return deleted;
	}

	public List<Event> readEventByConf(int confId) {
		List<Event> list = new ArrayList<>();

		try {
			sess.beginTransaction();
			Query q = sess.createQuery("select e.conferenceRoom.id, e.username ,e.start ,e.end, e.title, e.empCode from Event e where e.conferenceRoom.id=:confg");
			q.setParameter("confg", confId);
			list = q.list();
		} catch (Exception e) {
			if (sess.getTransaction() != null) {
				sess.getTransaction().rollback();
			}
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
		}

		return list;
	}

	public boolean isEventByConf(Event event) {
		long count = 0;
		try {
			sess.beginTransaction();
			Query q = sess.createQuery(
					"select count(e) from Event e where e.conferenceRoom.id =:conf AND (e.start <= :newEnd AND e.end >= :newStart)");
			q.setParameter("conf", event.getConferenceRoom().getId());
			q.setParameter("newStart", event.getStart());
			q.setParameter("newEnd", event.getEnd());

			count = (Long) q.getSingleResult();

			sess.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			sess.getTransaction().rollback();
		} finally {
			if (sess.getTransaction().isActive()) {
				sess.getTransaction().rollback();
			}
		}

		return count == 0;
	}

}
