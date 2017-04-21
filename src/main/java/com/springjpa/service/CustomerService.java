package com.springjpa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.dao.CustomerRepository;
import com.springjpa.dto.CustomerDTO;
import com.springjpa.model.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerDTO addCustomer(CustomerDTO customerDTO ){
		Customer customer=new Customer(customerDTO.getFirstName(),customerDTO.getLastName());
		customerRepository.save(customer);
		customerDTO.setId(customer.getId());
		return customerDTO;
	}

	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> customerDTOList=new ArrayList<>();
		List<Customer> customerList=customerRepository.findAll();
		if(customerList!=null){
			for (Customer customer : customerList) {
				CustomerDTO customerDTO=new CustomerDTO();
				customerDTO.setId(customer.getId());
				customerDTO.setFirstName(customer.getFirstName());
				customerDTO.setLastName(customer.getLastName());
				customerDTOList.add(customerDTO);
			}
		}
		return customerDTOList;
	}
}
