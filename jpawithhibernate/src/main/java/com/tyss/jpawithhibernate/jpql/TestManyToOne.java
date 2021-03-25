package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.onetomany.PencilBox;
import com.tyss.onetomany.Pencils;


public class TestManyToOne {
public static void main(String[] args) {
	EntityTransaction transaction=null;
	EntityManager manager =null;
	PencilBox box =   new PencilBox();
	box.setBoxId(111);
	box.setBname("abc");
	Pencils pencils = new Pencils();
	pencils.setPid(14);
	pencils.setColor("gray");
//	pencils.setBox(box);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	try {
		
		manager = factory.createEntityManager();
	transaction = manager.getTransaction();
	//many to one
	transaction.begin();
	manager.persist(pencils);
	transaction.commit();
	//below will insert data into tablses in case of unidirectional
	//one to many
	    PencilBox boxs = manager.find(PencilBox.class,111 );
	    pencils.setBox(boxs);
	    System.out.println(boxs.getBoxId());
	    System.out.println(boxs.getBname());
//	    System.out.println(boxs.getPencils());
//	    System.out.println(boxs.getBoxId());
//	    System.out.println(boxs.getBname());
//		
	    
		System.out.println("record inserted");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		transaction.rollback();
		e.printStackTrace();
	}
	manager.close();
}
}
