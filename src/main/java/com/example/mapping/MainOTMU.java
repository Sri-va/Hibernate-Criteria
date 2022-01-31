package com.example.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibermate.criteria.HibernateUtil;

public class MainOTMU {
    public static void main(String[] args) {
          Session session = null;
          Transaction transaction = null;
          try {
             session = HibernateUtil.getSessionFactory().openSession();
             transaction = session.beginTransaction();
          
             Employee employee1 = new Employee();
             employee1.setName("Adam");
             employee1.setDesignation("Manager");
             Employee employee2 = new Employee();
             employee2.setName("Miller");
             employee2.setDesignation("Software Engineer");
             Employee employee3 = new Employee();
             employee3.setName("Smith");
             employee3.setDesignation("Associate  Engineer");
             Department department = new Department();
             department.setName("IT Department");
             department.getEmployees().add(employee1);
             department.getEmployees().add(employee2);
             department.getEmployees().add(employee3);
             session.persist(department);
             transaction.commit();
          } catch (Exception e) {
             if (transaction != null) {
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
