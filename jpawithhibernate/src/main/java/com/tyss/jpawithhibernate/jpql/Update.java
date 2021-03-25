package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpawithhibernate.dto.Person;

public class Update {
public static void main(String[] args) {
	EntityTransaction transaction=null;
	EntityManager manager =null;
//	Person person = new Person();
//	person.setId(24);
//	person.setName("sam");
//	person.setSalary(20000);
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	try {
		
		manager = factory.createEntityManager();
//		String jpql = "update Person p set p.salary=10000 where p.id=12" ;
		String jpql = "update Person p set p.salary=10000 where p.id=:pid" ;
				transaction = manager.getTransaction(); 
		transaction.begin();
		Query query = manager.createQuery(jpql);
		query.setParameter("pid",24);
		int record = query.executeUpdate();
		transaction.commit();
		
		if(record!=0)
		System.out.println("record updated"+record);
		else
			System.out.println("record not updated"+record);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		transaction.rollback();

	}
	manager.close();
}//end of method
}
