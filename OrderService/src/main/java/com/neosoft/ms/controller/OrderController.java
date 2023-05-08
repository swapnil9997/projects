package com.neosoft.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.ms.model.MyOrder;
import com.neosoft.ms.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@Value("{app.title}")
	private String title;

	@GetMapping("/data")
	public ResponseEntity<String> showProductMsg() {
		return new ResponseEntity<String>("Value of title from Config Server: " + title, HttpStatus.OK);
	}

	@GetMapping("/order")
	public List<MyOrder> getAllOrders() {
		return (List<MyOrder>) orderService.getMyOrders();
	}

	@GetMapping("/order/{id}")
	public MyOrder getOrderById(@PathVariable(value = "id") int orderId) {
		return orderService.getMyOrderById(orderId);

	}

	@PostMapping("/saveOrder")
	public MyOrder saveOrder(@RequestBody MyOrder order) {
		return orderService.saveOrder(order);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrderById(@PathVariable(value = "id") int orderId) {
		orderService.deleteOrderById(orderId);
	}

}
