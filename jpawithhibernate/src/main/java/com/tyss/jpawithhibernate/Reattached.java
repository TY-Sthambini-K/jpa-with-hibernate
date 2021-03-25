package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpawithhibernate.dto.Person;

public class Reattached {
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
			Person record = manager.find(Person.class,1);
			
			System.out.println("Before detach "+manager.contains(record));
			manager.detach(record);
			System.out.println("after detach "+manager.contains(record));
			System.out.println("record updated");
			Person mergeRecord = manager.merge(record);
//			System.out.println(mergeRecPerson);
			mergeRecord.setName("sthambini");
			transaction.commit();
			System.out.println("after reattaching");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();
	}//end of method
}
