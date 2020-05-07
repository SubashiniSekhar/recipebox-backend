package org.myboxofrecipes.configutil;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BackendUtil {

	private static SessionFactory sessionFactory;

	public void readSpringConfig() {
		// ApplicationContext recipecontext = new ClassPathXmlApplicationContext

	}

	public static SessionFactory getHibernateSessionFactory() {

		sessionFactory = (SessionFactory) new Configuration().configure().buildSessionFactory();
		return sessionFactory;

	}

	public static void closeSessionFactory() {

		getHibernateSessionFactory().close();

	}
	
	public static EntityManager getEntityManager() {
		Session sess = getHibernateSessionFactory().openSession();
		EntityManager em = sess.getEntityManagerFactory().createEntityManager();
		return em;
		
	}

}
