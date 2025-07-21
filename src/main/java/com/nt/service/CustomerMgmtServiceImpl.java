package com.nt.service;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public Iterable<Customer> showCustomerSorted(boolean flag, String ...properties) {

		Sort sort = Sort.by(flag?Direction.ASC:Direction.DESC, properties);
		
		Iterable<Customer> it = custRepo.findAll(sort);//1............................................
		
		
		return it;
	}

	@Override
	public Page<Customer> showCustomerByPageNo(int pageNo, int pageSize, boolean flag, String ...properties) {

		Sort sort = Sort.by(flag?Direction.ASC:Direction.DESC, properties);
		Pageable p = PageRequest.of(pageNo-1, pageSize, sort);
		Page<Customer> page = custRepo.findAll(p);//2...................................................
		
		return page;
		
	}

	@Override
	public void showCustomerDataPageByPage(int pageSize) {

		//get records count
		long count = custRepo.count();
		long pagesCount = count/pageSize;
		if(count%pageSize!=0)
		{
			pagesCount++;
		}
		
		//display each page record
		for(int i=0;i<pagesCount;i++)
		{
			PageRequest p = PageRequest.of(i, pageSize);
			//get and display each page records.
			Page<Customer> page = custRepo.findAll(p);
			List<Customer> content = page.getContent();
			for(Customer c : content)
			{
				System.out.println(c);
				
			}
			
			
		}
		
	}
}
