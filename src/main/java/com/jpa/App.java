package com.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.beans.Students;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//    	Students stud = new Students();
//    	stud.setName("Nilesh");
//    	stud.setCity("Dombivali");
//    	stud.setLastName("pandey");
//    	stud.setDate(new Date());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Save Entity
//        em.persist(stud);  
//        System.out.println("successful");

		// Delete Entity
//    	Students students = em.find(Students.class, 17);
//    	em.remove(students);
//        tx.commit();

		// Update Entity
		Students students = em.find(Students.class, 16);
		students.setName("Sandeep");
		students.setCity("Pisavali");
		em.merge(students);
		tx.commit();
		

		Query query = em.createQuery("from Students");
//    	Query query = em.createNativeQuery("select * from students_details");
//    	List<Object[]> list = query.getResultList();
		List<Students> list = query.getResultList();
		for (Students s : list) {
			System.out.println(s);
		}

		em.close();
	}
}
