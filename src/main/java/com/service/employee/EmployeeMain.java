package com.service.employee;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeMain {

	public static void main(String[] args) {

		Transaction transaction=null;
		Session session=null;
		session=HibernateUtil.getSessionFactory().openSession();
		transaction=session.beginTransaction();
		
		Employee e=new Employee("Srivatsan", "N", "Sri", "sri123", 5000, "abc@gmail.com", "1234560");
		
		System.out.println(e.submitRequest());
		session.save(e);
		transaction.commit();
	}
}
