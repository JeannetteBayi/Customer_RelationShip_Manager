package com.luv2code.springdemo.dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//injecting the session factory
	
	@Autowired
	private SessionFactory sessionFactory; //bean defined in configuration file
	
	@Override
	@Transactional  //tell spring to manage starting and stopping of sessions. sessio.begin, session.commit
	public List<Customer> getCustomers() {
		
		//get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create the query
		Query <Customer> theQuery=  currentSession.createQuery(" from Customer", Customer.class);
			
		//execute the query
		List <Customer> customers = theQuery.getResultList();
		
		
		//return the list of customers
		return customers;
	}

}
