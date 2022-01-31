package com.hibermate.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CriteriaExamples02 {
public static void main(String[] args) {
    Transaction transactionOne = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    //1 - Create a CriteriaBuilder instance by calling the Session.getCriteriaBuilder() method.
    CriteriaBuilder builder = session.getCriteriaBuilder();
    
    //2 - Create a query object by creating an instance of the CriteriaQuery interface.
    CriteriaQuery<Student> query = builder.createQuery(Student.class);
    
    //3 - Set the query Root by calling the from() method on the CriteriaQuery object to define a range variable in FROM clause.
    Root<Student> root = query.from(Student.class);
    
    //4 - Specify what the type of the query result will be by calling the select() method of the CriteriaQuery object.
    query.select(root);
    
    //5 - Prepare the query for execution by creating a org.hibernate.query.Query instance by calling the Session.createQuery() method, specifying the type of the query result.
    Query<Student> q = session.createQuery(query);
    
    //6 - Execute the query by calling the getResultList() or getSingleResult() method on the org.hibernate.query.Query object.
    List<Student> list = q.getResultList();
    
    for(Student slist:list)
        System.out.println(slist);
    
   // List<Student> list1 = q.getResultList();
    
}
}
