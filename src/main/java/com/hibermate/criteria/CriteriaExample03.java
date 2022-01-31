package com.hibermate.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CriteriaExample03 {
public static void main(String[] args) {
    Transaction transactionOne = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Item> cr = cb.createQuery(Item.class);
    Root<Item> root = cr.from(Item.class);
    //get all the items.
    cr.select(root);
    
    //To get items having a price of more than 10:
    //cr.select(root).where(cb.gt(root.get("itemPrice"), 12));
    
   // cr.select(root).where(cb.like(root.get("itemName"), "%tem%"));
    
        //Records having itemPrice in between 100 and 200:
        //cr.select(root).where(cb.between(root.get("itemPrice"), 100, 200));
        //Items having itemName in Skate Board, Paint and Glue:
        //cr.select(root).where(root.get("itemName").in("Skate Board", "Paint", "Glue"));
        //To check if the given property is null:
        //cr.select(root).where(cb.isNull(root.get("itemDescription")));
        //To check if the given property is not null:
        //cr.select(root).where(cb.isNotNull(root.get("itemDescription")));
    
    
    //the Criteria API allows us to easily chain expressions:
    /*Predicate greaterThanPrice = cb.gt(root.get("itemPrice"), 1000);
    Predicate chairItems = cb.like(root.get("itemName"), "Chair%");*/
    
    /*Items with the above-defined conditions joined with Logical OR:
    cr.select(root).where(cb.or(greaterThanPrice, chairItems));*/
    /*
     * To get items matching with the above-defined conditions joined with Logical
     * AND: cr.select(root).where(cb.and(greaterThanPrice, chairItems));
     */
    
    
    //order the list in ascending order of the name and then in descending order of the price:
    /*
     * cr.orderBy( cb.asc(root.get("itemName")), cb.desc(root.get("itemPrice")));
     */
        
    Query<Item> query = session.createQuery(cr);
    List<Item> results = query.getResultList();
    results.forEach(i->System.out.println(i));
}
}