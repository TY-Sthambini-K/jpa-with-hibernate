package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpawithhibernate.dto.Person;

public class DeleteDemo {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			Person record = manager.find(Person.class, 2);
			manager.remove(record);

			transaction.commit();
			System.out.println("record deleted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
	}// end of method
}// end of class
