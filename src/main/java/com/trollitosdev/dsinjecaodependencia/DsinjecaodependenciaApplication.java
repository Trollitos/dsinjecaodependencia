package com.trollitosdev.dsinjecaodependencia;

import com.trollitosdev.dsinjecaodependencia.entities.Order;
import com.trollitosdev.dsinjecaodependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DsinjecaodependenciaApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DsinjecaodependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Order> orderList = new ArrayList<>();
		orderList.add(new Order(1034, 150.00, 20.0));
		orderList.add(new Order(2282, 800.00, 10.0));
		orderList.add(new Order(1309, 95.90, 0.0));

		for(Order order : orderList) {
			System.out.println("\nPedido código " + order.getCode() + "\nValor total: R$ " + String.format("%.2f",orderService.total(order)));
		}

	}
}
