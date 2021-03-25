package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;

import com.tyss.jpawithhibernate.onetoone.AdharDetails;
import com.tyss.jpawithhibernate.onetoone.Persons;

import jpawithhibernate.dto.Person;

public class TestOneToOne {

	public static void main(String[] args) {
		EntityTransaction transaction=null;
		EntityManager manager =null;
		AdharDetails aadhar = new AdharDetails();
		aadhar.setAid(145);
		aadhar.setAddress("rajajinagar");
		Persons person = new Persons();
		person.setId(13);
		person.setName("sam");
		person.setAadhar(aadhar);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		try {
			
			manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		AdharDetails record = manager.find(AdharDetails.class, 123);
		System.out.println(record.getPerson().getId());
		System.out.println(record.getPerson().getName());
		System.out.println(record.getAid());
		System.out.println(record.getAddress());
		//below will insert data into tablses in case of unidirectional
//			transaction.begin();
//			manager.persist(person);
//			transaction.commit();
			System.out.println("record inserted");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();
	}//end of method
}

