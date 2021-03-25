package com.tyss.jpawithhibernate.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.manytomany.CourseInfo;
import com.tyss.manytomany.Students;

public class TestManyToMany2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = null;
		EntityTransaction transaction = null;
	
//	List<Student> stud=new ArrayList<Student>();
	List<CourseInfo> courses=new ArrayList<CourseInfo>();
	
	CourseInfo course=new CourseInfo();
	course.setCid(8);
	course.setCname("java");
	
	CourseInfo course1=new CourseInfo();
	course1.setCid(9);
	course1.setCname("sql");
	
	courses.add(course);
	courses.add(course1);
	

//	Courses java=manager.find(Courses.class, 8);
//	Courses sql=manager.find(Courses.class, 9);
//	
//	courses.add(java);
//	courses.add(sql);
//	
	Students student=new Students();
	student.setSid(21);
	student.setName("ramya");
	student.setCourse(courses);
	
	Students student1=new Students();
	student1.setSid(22);
	student1.setName("ranju");
	student1.setCourse(courses);

		try {
			manager = factory.createEntityManager();
			// also a interface which is used to create a entity manager
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(student);
			manager.persist(student1);
			transaction.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();

		}
		System.out.println("record inserted");
		manager.close();
	}

}
