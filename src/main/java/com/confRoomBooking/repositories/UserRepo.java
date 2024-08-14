package com.confRoomBooking.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.confRoomBooking.models.User;
import com.confRoomBooking.utilities.SessionGenerator;


public class UserRepo implements UserRepoImpl{
	
	Session sess;
	public UserRepo() {
		sess = new SessionGenerator().getSess();
	}
	
	@Override
	public int addUser(User user) {
		Integer id = 0;
		try {
			sess.beginTransaction();
			id = (Integer) sess.save(user);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return id;
	}

	@Override
	public User readUser(int id) {
		User user = new User();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from User where id = "+id);
			user = (User) q.list().get(0);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		
		return user;
	}

	@Override
	public List<User> readAllUser() {
		List<User> list = new ArrayList<>();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from User");
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
	public boolean updateUser(User user) {
		boolean updated = false;
		try {
			sess.beginTransaction();
			sess.saveOrUpdate(user);
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
	public boolean deleteUser(int id) {
		boolean deleted = false;
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("delete from User where id=:uid");
			q.setParameter("uid", id);
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

	@Override
	public User readUserByUserNamePassword(String userName, String passWord) {
		User user  =new User();
		try {
			sess.beginTransaction();
			Query q = sess.createQuery("from User where userName=:uname and password=:pass");
			q.setParameter("uname", userName);
			q.setParameter("pass", passWord);
			user = (User) q.list().get(0);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
		}finally {
			sess.close();
		}
		return user;
	}

}
