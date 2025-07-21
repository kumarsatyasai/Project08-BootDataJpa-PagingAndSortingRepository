package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer>,PagingAndSortingRepository<Customer, Integer> {

}
