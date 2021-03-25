package com.tyss.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpawithhibernate.dto.Person;

public class GetAll {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager manager = factory.createEntityManager();
	String jpql = "select s from Person s";
	Query query = manager.createQuery(jpql);
	List<Person> PersonList = query.getResultList();
	for(Person person:PersonList) {
		System.out.println("Person Id "+person.getId());
		System.out.println("Person Id "+person.getName());
		System.out.println("Person Id "+person.getSalary());
	}
}
}
