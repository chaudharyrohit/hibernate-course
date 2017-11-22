package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = createUser();
		
		session.save(user);
		session.getTransaction().commit();
		
		
		session.close();
		sessionFactory.close();
	}

	private static User createUser() {
		User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedBy("kevin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("rohit123@yahoo.com");
		user.setFirstName("Ramanna");
		user.setLastName("Thalari");
		user.setLastUpdatedBy("kevin");
		user.setLastUpdatedDate(new Date());
		return user;
	}

}
