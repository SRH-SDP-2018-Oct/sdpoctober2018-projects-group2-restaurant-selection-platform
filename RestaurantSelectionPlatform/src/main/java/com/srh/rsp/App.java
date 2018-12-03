package com.srh.rsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.srh.rsp.entity.CustomerLogin;
import com.srh.rsp.entity.Employee;
import com.srh.rsp.entity.Sakila;

/**
 * Hello world!
 *
 */

public class App {
	private static EntityManager em;

	public static void main(String[] args) {

		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-rsp");
		 * EntityManager em = emf.createEntityManager(); Sakila sakila =
		 * em.find(Sakila.class,1); System.out.println(sakila);
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-rsp");
		em = emf.createEntityManager();

		createEmployee(1, "Ravi", "Raj", "Textile");
		createEmployee(2, "Amit", "Raj", "IT");
		createEmployee(3, "Nitish", "Kumar", "Marketing");

	}

	private static void createEmployee(int id, String firstName, String lastName, String dept) {
		em.getTransaction().begin();
		Employee emp = new Employee(id, firstName, lastName, dept);
		em.persist(emp);
		em.getTransaction().commit();
	}
}
