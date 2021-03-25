package com.tyss.jpawithhibernate.jpql;

import java.lang.annotation.Target;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.tyss.manytomany.CourseInfo;
import com.tyss.manytomany.Students;

public class TestManyToMany {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;

		ArrayList<CourseInfo> al1 = new ArrayList<CourseInfo>();
		ArrayList<CourseInfo> al2 = new ArrayList<CourseInfo>();

		CourseInfo info1 = new CourseInfo();
		info1.setCid(1);
		info1.setCname("java");

		CourseInfo info2 = new CourseInfo();
		info2.setCid(2);
		info2.setCname("JavaScript");

		CourseInfo info3 = new CourseInfo();
		info3.setCid(3);
		info3.setCname("React JS");

		al1.add(info1);
		al1.add(info2);
		al1.add(info3);

		al2.add(info1);
		al2.add(info2);
		al2.add(info3);

//		info1.getStudents();
		Students s1 = new Students();
		s1.setSid(14);
		s1.setName("sthambini");
		s1.setCourse(al1);
		s1.setCourse(al2);
		Students s2 = new Students();
		s2.setSid(15);
		s2.setName("namz");
		s2.setCourse(al2);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			// below will insert data into tablses in case of unidirectional
			transaction.begin();
//			manager.persist(info1);
			manager.persist(s1);
	        manager.persist(s2);
			transaction.commit();

			System.out.println("record inserted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();
	}
}
