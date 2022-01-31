package com.hibernate.mapping.otm.binary;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;

import com.hibermate.criteria.HibernateUtil;

public class Main2 {

	public static void main(String[] args) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Query<Department> query=session.createQuery("FROM Department");
		 List<Department> dept=query.list();
		 for(Department d: dept) {
			 System.out.println(d.getName());
			 List<Employee> emp1 = d.getEmployees();
			 for(Employee e1 : emp1) 
				 System.out.println(e1.getName() +"-->" +e1.getDesignation());
		 }			
	}
}
