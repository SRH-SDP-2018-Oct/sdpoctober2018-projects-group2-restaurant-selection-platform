package com.srh.rsp.dbAccess;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.SearchHit;

public class SearchHitCRUD {
	long itemid, hits;
	boolean rdflag;

	public void setSearchHit(long itemid, long hits, boolean rdflag) {

		SearchHit searchHit = new SearchHit();
		searchHit.setItemId(itemid);
		searchHit.setHits(hits);
		searchHit.setRdFlag(rdflag);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(searchHit);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}

}
