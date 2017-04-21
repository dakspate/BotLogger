package com.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.dto.CustomerDTO;
import com.springjpa.service.CustomerService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void contextLoads() {
		//List<CustomerDTO> customerDTOList=customerService.getAllCustomers();		
		//assertThat(customerDTOList.size()).isEqualTo(1);
	}

}
