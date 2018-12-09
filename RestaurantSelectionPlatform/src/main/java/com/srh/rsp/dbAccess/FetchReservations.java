package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantReservation;

public class FetchReservations {

	public List<RestaurantReservation> fetchReservationDetails(long restaurantid, long customerid) {

		// if restaurantid is not null then fetch for the owner
		// elseif customerid is not null then fetch for customer

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
		CriteriaQuery<RestaurantReservation> criteriaQuery = cbuilder.createQuery(RestaurantReservation.class);
		Root<RestaurantReservation> reseravationRoot = criteriaQuery.from(RestaurantReservation.class);
		criteriaQuery.select(reseravationRoot);
		if (restaurantid != 0) {
			criteriaQuery.where(cbuilder.equal(reseravationRoot.get("restaurantId"), restaurantid));
			List<RestaurantReservation> listofReservations = em.createQuery(criteriaQuery).getResultList();
			em.close();
			PersistenceManager.INSTANCE.close();
			return listofReservations;
		} else {
			criteriaQuery.where(cbuilder.equal(reseravationRoot.get("customerId"), customerid));
			List<RestaurantReservation> listofReservations = em.createQuery(criteriaQuery).getResultList();
			em.close();
			PersistenceManager.INSTANCE.close();
			return listofReservations;
		}

	}

}
