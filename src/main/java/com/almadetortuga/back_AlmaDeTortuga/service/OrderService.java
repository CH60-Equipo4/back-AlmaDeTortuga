package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.exceptions.OrderNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.Order;
import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Lista de Pedidos
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    // Crear un Pedido
    public Order createOrder(Order newOrder){
        return orderRepository.save(newOrder);
    }



    // Metodo para buscar por id
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException(id));
    }
}
