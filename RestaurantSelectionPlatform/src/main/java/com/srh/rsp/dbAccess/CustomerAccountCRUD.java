package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.CustomerLogin;

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
		PersistenceManager.INSTANCE.close();
	}

	public List<CustomerLogin> fetchCustomerLoginOnCustomerid(Long customerid) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
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
		PersistenceManager.INSTANCE.close();
		return customerType.get(0);
	}

}