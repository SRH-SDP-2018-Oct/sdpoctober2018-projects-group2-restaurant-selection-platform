package com.srh.rsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public enum PersistenceManager {
	INSTANCE;

	private EntityManagerFactory emFactory;

	private PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory("pu-rsp");
	}

	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return emFactory.getCriteriaBuilder();
	}

	public void close() {
		emFactory.close();
	}
}
