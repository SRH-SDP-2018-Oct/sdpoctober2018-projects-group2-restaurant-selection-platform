package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.CusineType;

public class CuisineCRUD {
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
	
	public List<CusineType> litsOfCusine() {
		CriteriaQuery<CusineType> criteriaQuery = cbuilder.createQuery(CusineType.class);
		Root<CusineType> cusineRoot = criteriaQuery.from(CusineType.class);
		criteriaQuery.select(cusineRoot);
		List<CusineType> cusineDetails = em.createQuery(criteriaQuery).getResultList();
		return cusineDetails;
	}
	
	public CusineType cusineName(long cusineID) {
		CriteriaQuery<CusineType> criteriaQuery = cbuilder.createQuery(CusineType.class);
		Root<CusineType> cusineRoot = criteriaQuery.from(CusineType.class);
		criteriaQuery.select(cusineRoot);
		criteriaQuery.where(cbuilder.equal(cusineRoot.get("cuisineId"), cusineID));
		List<CusineType> cusineDetails = em.createQuery(criteriaQuery).getResultList();
		return cusineDetails.get(0);
	}
}
