package com.infiniteskills.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.infiniteskills.data.entities.User;

public class HibernateUtils {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			//getSessionFactoryUsingHibernatePropertyFile();
			
			return getSessionFactoryUsingHibernateCfgFile();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Error occured building SessionFactory!");
		}
	}
	
	private static SessionFactory getSessionFactoryUsingHibernateCfgFile() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build());
	}

	@SuppressWarnings("unused")
	private static SessionFactory getSessionFactoryUsingHibernatePropertyFile() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
				.build());
		
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
