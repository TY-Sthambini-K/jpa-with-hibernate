package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpawithhibernate.dto.Person;

public class UpdateDemo {

	public static void main(String[] args) {
		EntityTransaction transaction=null;
		EntityManager manager =null;
//		Person person = new Person();
//		person.setId(24);
//		person.setName("sam");
//		person.setSalary(20000);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		try {
			
			manager = factory.createEntityManager();
		transaction = manager.getTransaction(); 
			transaction.begin();
//			manager.persist(person);
			Person record = manager.find(Person.class,2);
			record.setName("sam");
			transaction.commit();
			System.out.println("record updated");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();
	}//end of method
}
