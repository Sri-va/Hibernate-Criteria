package com.example.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibermate.criteria.HibernateUtil;




public class MainMTM {
	 public static void main(String[] args) {
	      Session session = null;
	      Transaction transaction = null;
	      try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	     

	         Address address1 = new Address("Bengaluru", "Karnataka", "India", "560016");
	         Address address2 = new Address("Jaipur", "Rajasthan", "India", "302017");

	         // Employee1 have 2 addresses
	         Employeee employee1 = new Employeee("Ravindra Singh", "Sales Manager", 450000);
	         employee1.getAddresses().add(address1);
	         employee1.getAddresses().add(address2);

	         // Employee2 have 1 address
	         Employeee employee2 = new Employeee("Mohit Sharma", "Software Engineer", 850000);
	         employee2.getAddresses().add(address1);

	         session.save(employee1);
	         session.save(employee2);
	         transaction.commit();

	         System.out.println("Records saved successfully");

	      } catch (Exception e) {
	         if (transaction != null) {
	            System.out.println("Transaction is being rolled back.");
	            transaction.rollback();
	         }
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	     
	   }
}