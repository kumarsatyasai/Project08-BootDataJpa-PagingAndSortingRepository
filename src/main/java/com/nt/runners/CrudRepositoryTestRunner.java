package com.nt.runners;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {

		try {
			
			/*
			 * Iterable<Customer> iterable = custService.showCustomerSorted(false, "name",
			 * "cadd");
			 * 
			 * 
			 * for(Customer c : iterable) { System.out.println(c); }
			 */
			
			Page<Customer> page = custService.showCustomerByPageNo(1, 3, true, "name", "cadd");
			List<Customer> content = page.getContent();
			System.out.println("PageNo::"+(page.getNumber()+1)+"\n"+page.getTotalPages()+" records are :");
			
			content.forEach(System.out::println);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
