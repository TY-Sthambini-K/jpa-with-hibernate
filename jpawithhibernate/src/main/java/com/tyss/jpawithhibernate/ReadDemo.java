package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpawithhibernate.dto.Person;

public class ReadDemo {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager manager = factory.createEntityManager();
	Person person = manager.find(Person.class,2);
	System.out.println("Person Id "+person.getId());
	System.out.println("Person Id "+person.getName());
	System.out.println("Person Id "+person.getSalary());
	manager.close();
}
}
