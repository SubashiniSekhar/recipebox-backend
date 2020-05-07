package org.myboxofrecipes.daolayer;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.myboxofrecipes.configutil.*;

public class CrudDAO<E> {

	private Session sess;
	private Transaction tx;
	private static SessionFactory sessFactory;
	static {
		sessFactory = BackendUtil.getHibernateSessionFactory();
	}

	public <E> List<E> getAll(Class<E> e) {
		startBackendTransaction();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(e);
		Root<E> rootEntry = cq.from(e);
		CriteriaQuery<E> all = cq.select(rootEntry);
		TypedQuery<E> allQuery = sess.createQuery(all);
		List<E> alllist = allQuery.getResultList();
		commitBackendTransaction();
		return alllist;
	}

	public <K> E get(Class<E> e, K tolookfor) {
		startBackendTransaction();
		Object neededobj = sess.get(e, (Serializable) tolookfor);
		commitBackendTransaction();
		return (E) neededobj;
	}

	public <K> E remove(Class<E> e, K tolookfor) {
		startBackendTransaction();
		Object neededobj = sess.get(e, (Serializable) tolookfor);
		sess.delete(neededobj);
		commitBackendTransaction();
		return (E) neededobj;
	}

	public <K> E update(K id) {
		return null;

	}

	public E save(E e) {
		startBackendTransaction();
		if (e != null) {
			String savedentity = (String) sess.save(e);
			System.out.println("save called with transaction === " + savedentity);
		}
		commitBackendTransaction();
		return e;
	}

	private void startBackendTransaction() {		
		if( sess== null || !sess.isOpen()) {
			sess = sessFactory.openSession();
		}

		tx = sess.beginTransaction();
	}

	private void commitBackendTransaction() {
		tx.commit();
		//sess.close();
		//BackendUtil.closeSessionFactory();
	}

}
