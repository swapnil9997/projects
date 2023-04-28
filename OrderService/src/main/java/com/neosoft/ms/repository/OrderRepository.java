package com.neosoft.ms.repository;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.ms.model.MyOrder;

public interface OrderRepository extends CrudRepository<MyOrder, Integer> {
	
	public MyOrder getMyOrderById(int id);

}
