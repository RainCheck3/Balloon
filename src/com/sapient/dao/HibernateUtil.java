package com.sapient.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionfactory;
	private static Configuration configuration;
	static {
		configuration = new AnnotationConfiguration();
		configuration = configuration.configure();
		sessionfactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionfactory == null)
			sessionfactory = configuration.buildSessionFactory();
		return sessionfactory;
	}
}
