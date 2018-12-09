package com.srh.rsp.dbAccess;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.CustomerLogin;

public class NewCustomerAccount {
	String username, password, email;
	long phonenumber;

	public void setCustomerAccount(String username, String password, String email, String customertype,
			long phonenumber) {
		CustomerLogin customerLogin = new CustomerLogin();

		customerLogin.setUserName(username);
		customerLogin.setPassword(password);
		customerLogin.setEmailId(email);
		customerLogin.setCustomerType(customertype);
		customerLogin.setPhoneNumber(phonenumber);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(customerLogin);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}