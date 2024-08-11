package com.confRoomBooking.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionGenerator {
	private Session sess;
	public SessionGenerator() {
		try {
			SessionFactory fact = new Configuration().configure().buildSessionFactory();
			sess = fact.openSession();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public Session getSess() {
		return sess;
	}
	
}
