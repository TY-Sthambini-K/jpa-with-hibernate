package com.tyss.jpawithhibernate.jpql;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpawithhibernate.dto.Person;

public class Delete {
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
//			String jpql = "delete from Person s where s.id=2";
			String jpql = "delete from Person s where s.id=:pid";
			transaction = manager.getTransaction(); 
			transaction.begin();
			Query query = manager.createQuery(jpql);
			query.setParameter("pid",2);
			int record = query.executeUpdate();
			transaction.commit();
			if(record!=0) {
				System.out.println("record deleted "+record);
			}else {
				System.out.println("record not deleted "+record);
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
	}//end of method
}
