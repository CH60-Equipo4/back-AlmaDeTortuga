package com.almadetortuga.back_AlmaDeTortuga.service;
import com.almadetortuga.back_AlmaDeTortuga.exceptions.OrderNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.Order;
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

    // METODO PARA LISTADO DE TODOS LOS PEDIDOS
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    // METODO PARA CREACION DE UN NUEVO PEDIDO
    public Order createOrder(Order newOrder){
        return orderRepository.save(newOrder);
    }

    // METODO PARA BUSQUEDA DE ORDEN POR ID
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException(id));
    }

    // METODO PARA ACTUALIZAR UN PEDIDO POR ID
    public Order updateUser(Order order, Long id){
        return orderRepository.findById(id).map(orderMap -> {
            orderMap.setDate(order.getDate());
            orderMap.setTotal(order.getTotal());
            orderMap.setStatus(order.getStatus());
            return orderRepository.save(orderMap);
        }).orElseThrow(() -> new OrderNotFoundException(id));
    }

    // METODO PARA ELMINIAR UN PEDIDO POR ID
    public void deleteOrder(Long id){
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }else {
            throw new OrderNotFoundException(id);
        }
    }
}
