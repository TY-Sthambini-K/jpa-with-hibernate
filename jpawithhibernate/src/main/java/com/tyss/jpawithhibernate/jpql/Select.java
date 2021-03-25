package com.tyss.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpawithhibernate.dto.Person;

public class Select {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select s from Person s where s.id=1";
		Query query = manager.createQuery(jpql);
//		List<Person> PersonList = query.getResultList();
//		for(Person person:PersonList) {
		Person person = (Person) query.getSingleResult();
			System.out.println("Person Id "+person.getId());
			System.out.println("Person Id "+person.getName());
			System.out.println("Person Id "+person.getSalary());
//		}
	}
}
