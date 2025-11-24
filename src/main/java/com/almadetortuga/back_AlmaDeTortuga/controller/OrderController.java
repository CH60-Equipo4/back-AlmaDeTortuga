package com.almadetortuga.back_AlmaDeTortuga.controller;
import com.almadetortuga.back_AlmaDeTortuga.exceptions.OrderNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.Order;
import com.almadetortuga.back_AlmaDeTortuga.service.OrderService;
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

    //ACTUALIZAR UN PEDIDO POR ID
    @PutMapping("/update-order/{id}")
    public ResponseEntity<Order> updateById(@RequestBody Order order, @PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(orderService.updateUser(order, id));
        }catch (OrderNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    //ELMINIAR UN PEDIDO POR ID
    @DeleteMapping("delete-order/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try{
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        }catch (OrderNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
