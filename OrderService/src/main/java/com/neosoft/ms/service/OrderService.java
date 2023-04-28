package com.neosoft.ms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.ms.model.MyOrder;
import com.neosoft.ms.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repo;

	
	public Iterable<MyOrder> getMyOrders(){
		return repo.findAll();
	}
	
	public MyOrder getMyOrderById(int id) {
		Optional<MyOrder> op = repo.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}
	
	public MyOrder saveOrder(MyOrder order) {
		return repo.save(order);
	}
	
	public void deleteOrderById(int orderId) {
		repo.deleteById(orderId);

	}

}
