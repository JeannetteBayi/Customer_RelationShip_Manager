package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject DAO into our controller
	@Autowired //Allow spring to scan for a component which implements this interface
	private CustomerDAO customerDAO;
	
	@RequestMapping("list")
	public String customerList (Model theModel){
		
		//get customers from our DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add those customers to our model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
		
	}

}
