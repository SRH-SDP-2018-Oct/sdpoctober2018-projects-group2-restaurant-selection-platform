package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.CustomerLogin;
import com.srh.rsp.entity.RestaurantReservation;

public class CustomerAccountCRUD {
	String username, password, email;
	long phonenumber;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

	public void setCustomerAccount(String username, String password, String email, String customertype,
			String phonenumber) {
		CustomerLogin customerLogin = new CustomerLogin();

		customerLogin.setUserName(username);
		customerLogin.setPassword(password);
		customerLogin.setEmailId(email);
		customerLogin.setCustomerType(customertype);
		customerLogin.setPhoneNumber(phonenumber);

		em.getTransaction().begin();
		em.persist(customerLogin);
		em.getTransaction().commit();
		em.close();
	}

	public List<CustomerLogin> fetchCustomerLoginOnCustomerid(Long customerid) {
		CriteriaQuery<CustomerLogin> criteriaQuery = cbuilder.createQuery(CustomerLogin.class);
		Root<CustomerLogin> customerLoginRoot = criteriaQuery.from(CustomerLogin.class);
		criteriaQuery.select(customerLoginRoot);
		criteriaQuery.where(cbuilder.equal(customerLoginRoot.get("customerId"), customerid));
		List<CustomerLogin> listofCustomerLogin = em.createQuery(criteriaQuery).getResultList();

		return listofCustomerLogin;
	}

	public CustomerLogin fetchCustomerType(String eMail, String password) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
		CriteriaQuery<CustomerLogin> criteriaQuery = cbuilder.createQuery(CustomerLogin.class);
		Root<CustomerLogin> customerRoot = criteriaQuery.from(CustomerLogin.class);
		criteriaQuery.select(customerRoot);
		criteriaQuery.where(cbuilder.equal(customerRoot.get("emailId"), eMail),
				cbuilder.equal(customerRoot.get("password"), password));
		List<CustomerLogin> customerType = em.createQuery(criteriaQuery).getResultList();
		if (customerType.isEmpty()) {
			// list is empty
			return null;
		}
		em.close();
		return customerType.get(0);
	}
	
	public CustomerLogin fetchCustomerID(String eMail, String password) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
		CriteriaQuery<CustomerLogin> criteriaQuery = cbuilder.createQuery(CustomerLogin.class);
		Root<CustomerLogin> customerRoot = criteriaQuery.from(CustomerLogin.class);
		criteriaQuery.select(customerRoot);
		criteriaQuery.where(cbuilder.equal(customerRoot.get("emailId"), eMail),
				cbuilder.equal(customerRoot.get("password"), password));
		List<CustomerLogin> customerType = em.createQuery(criteriaQuery).getResultList();
		if (customerType.isEmpty()) {
			//list is empty
			return null;
		}
		em.close();
		return customerType.get(0);
	}
	
	public CustomerLogin fetchCustomerProfile(long userID) {
		CriteriaQuery<CustomerLogin> criteriaQuery = cbuilder.createQuery(CustomerLogin.class);
		Root<CustomerLogin> customerLoginRoot = criteriaQuery.from(CustomerLogin.class);
		criteriaQuery.select(customerLoginRoot);
		criteriaQuery.where(cbuilder.equal(customerLoginRoot.get("customerId"), userID));
		List<CustomerLogin> customerProfile = em.createQuery(criteriaQuery).getResultList();

		return customerProfile.get(0);
	}
	
	public void editName(String name, CustomerLogin details) {
		CustomerLogin oldDetails = em.find(CustomerLogin.class, details.getCustomerId());
		em.getTransaction().begin();
		oldDetails.setUserName(name);
		em.getTransaction().commit();
		System.out.println("Name updated to " + name);
	}
	
	public void editEmail(String eMail, CustomerLogin details) {
		CustomerLogin oldDetails = em.find(CustomerLogin.class, details.getCustomerId());
		em.getTransaction().begin();
		oldDetails.setEmailId(eMail);
		em.getTransaction().commit();
		System.out.println("Email updated to " + eMail);
	}
	
	public void editPhoneNumber(String phoneNumber, CustomerLogin details) {
		CustomerLogin oldDetails = em.find(CustomerLogin.class, details.getCustomerId());
		em.getTransaction().begin();
		oldDetails.setPhoneNumber(phoneNumber);
		em.getTransaction().commit();
		System.out.println("Contact updated to " + phoneNumber);
	}
}