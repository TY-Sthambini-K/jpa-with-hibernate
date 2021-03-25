package com.tyss.jpawithhibernate.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.manytomany.CourseInfo;
import com.tyss.manytomany.Students;

public class TesManyToMany {
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

		List<CourseInfo> courses1 = new ArrayList<CourseInfo>();

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			CourseInfo java = manager.find(CourseInfo.class, 112);
			CourseInfo j2ee = manager.find(CourseInfo.class, 113);
			CourseInfo hibernate = manager.find(CourseInfo.class, 114);

			courses1.add(java);
			courses1.add(j2ee);
			courses1.add(hibernate);

			Students st1 = new Students();
			st1.setSid(8);
			st1.setName("saanvi");
			st1.setCourse(courses1);
			Students st2 = new Students();
			st2.setSid(9);
			st2.setName("ruchita");
			st2.setCourse(courses1);

			manager.persist(st1);
			manager.persist(st2);
			transaction.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback(); // Roll Back if Transaction is failed
		}

		manager.close();

	} // End of main
}
