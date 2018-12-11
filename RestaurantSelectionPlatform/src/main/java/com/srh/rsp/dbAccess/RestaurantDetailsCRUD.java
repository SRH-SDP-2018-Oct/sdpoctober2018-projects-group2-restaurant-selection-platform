package com.srh.rsp.dbAccess;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantDetails;

public class RestaurantDetailsCRUD {
	String restaurantname, emailid, city, region, housenumberstreet, picturelink;
	int countrykey, postalcode, subscriptionstatus;
	boolean petsallowed, partyspace, vegnon;
	long phonenumber, customerid;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

	public void setRestaurantDetails(String restaurantname, String emailid, String city, String region,
			String housenumberstreet, String picturelink, long customerid, int countrykey, int postalcode,
			boolean petsallowed, boolean partyspace, boolean vegnon, String phonenumber) {

		RestaurantDetails restaurantDetails = new RestaurantDetails();
		restaurantDetails.setRestaurantName(restaurantname);
		restaurantDetails.setEmailId(emailid);
		restaurantDetails.setCity(city);
		restaurantDetails.setRegion(region);
		restaurantDetails.setHousenumberStreet(housenumberstreet);
		restaurantDetails.setPictureLink(picturelink);
		restaurantDetails.setCustomerId(customerid);
		restaurantDetails.setCountryKey(countrykey);
		restaurantDetails.setPostalCode(postalcode);
		restaurantDetails.setSubscriptionStatus(1);
		restaurantDetails.setPetsAllowed(petsallowed);
		restaurantDetails.setVegNon(vegnon);
		restaurantDetails.setPhoneNumber(phonenumber);

		em.getTransaction().begin();
		em.persist(restaurantDetails);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();

	}

	public RestaurantDetails listOfRestaurantDetailsOnRestaurantId(Long restaurantid) {

		CriteriaQuery<RestaurantDetails> criteriaQuery = cbuilder.createQuery(RestaurantDetails.class);
		Root<RestaurantDetails> restaurantDetailsRoot = criteriaQuery.from(RestaurantDetails.class);
		criteriaQuery.select(restaurantDetailsRoot);
		criteriaQuery.where(cbuilder.equal(restaurantDetailsRoot.get("restaurantId"), restaurantid));
		List<RestaurantDetails> restaurantDetails = em.createQuery(criteriaQuery).getResultList();
		if (restaurantDetails.isEmpty()) {
			// list is empty
			return null;
		}
		em.close();
		PersistenceManager.INSTANCE.close();
		return restaurantDetails.get(0);
	}

	public List<RestaurantDetails> fetchRestaurantDetailsOnSearch(String search, String region) {

		CriteriaQuery<RestaurantDetails> criteriaQuery = cbuilder.createQuery(RestaurantDetails.class);
		Root<RestaurantDetails> restaurantDetailsRoot = criteriaQuery.from(RestaurantDetails.class);
		criteriaQuery.select(restaurantDetailsRoot);
		// EntityType<RestaurantDetails> type =
		// em.getMetamodel().entity(RestaurantDetails.class);
		// criteriaQuery.where(cbuilder.like(
		// cbuilder.lower(
		// restaurantDetailsRoot.get(type.getDeclaredSingularAttribute("restaurantName",
		// String.class))),
		// "%" + search.toLowerCase() + "%"));
		criteriaQuery.where(cbuilder.like(cbuilder.lower(restaurantDetailsRoot.get("restaurantName")),
				"%" + search.toLowerCase() + "%"), cbuilder.equal(restaurantDetailsRoot.get("region"), region));
		List<RestaurantDetails> listofRestaurantDetails = em.createQuery(criteriaQuery).getResultList();
		return listofRestaurantDetails;

	}

	public List<String> fetchAllRestaurantRegion() {
		CriteriaQuery<String> criteriaQuery = cbuilder.createQuery(String.class);
		Root<RestaurantDetails> restaurantDetailsRoot = criteriaQuery.from(RestaurantDetails.class);
		criteriaQuery.select(restaurantDetailsRoot.get("region").as(String.class));

		List<String> listOfRegions = em.createQuery(criteriaQuery).getResultList();

		Set<String> hs = new HashSet<>();
		hs.addAll(listOfRegions);
		listOfRegions.clear();
		listOfRegions.addAll(hs);
		return listOfRegions;
	}

	public List<RestaurantDetails> fetchRestaurantDetailsOnRegion(String region) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
		CriteriaQuery<RestaurantDetails> criteriaQuery = cbuilder.createQuery(RestaurantDetails.class);
		Root<RestaurantDetails> restaurantdetailsRoot = criteriaQuery.from(RestaurantDetails.class);
		criteriaQuery.select(restaurantdetailsRoot);
		criteriaQuery.where(cbuilder.equal(restaurantdetailsRoot.get("region"), region));

		List<RestaurantDetails> listofRestaurantDetails = em.createQuery(criteriaQuery).getResultList();
		return listofRestaurantDetails;

	}
}
