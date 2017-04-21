package com.springjpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.dto.CustomerDTO;
import com.springjpa.model.Customer;
import com.springjpa.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService; 
	
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public Map<String,Object> getAllCustomers(){
		List<CustomerDTO> customerList=customerService.getAllCustomers();
		Map<String,Object> result=new HashMap<String, Object>();
		result.put("operation_success", "true");
		result.put("customer_list", customerList);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.POST,produces="application/json")
	public Map<String,Object> saveCustomer(@RequestBody CustomerDTO customerDTO){
		
		customerService.addCustomer(customerDTO);
		Map<String,Object> result=new HashMap<String, Object>();
		result.put("operation_success", "true");
		result.put("customer", customerDTO);
		return result;
	}
	
	
	/*@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "<html>";
		
		for(Customer cust: repository.findByLastName(lastName)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}*/
}

