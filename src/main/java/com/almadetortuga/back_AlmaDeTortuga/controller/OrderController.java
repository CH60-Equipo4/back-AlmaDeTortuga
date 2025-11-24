package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.Order;
import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.service.OrderService;
import com.almadetortuga.back_AlmaDeTortuga.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // LISTADO DE TODOS LOS PEDIDOS
    @GetMapping
    public List<Order> findAllOrders(){
        return orderService.getOrders();
    }

    // CREACION DE UN NUEVO PEDIDO
    @PostMapping("/new-order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.createOrder(order));
    }
}
