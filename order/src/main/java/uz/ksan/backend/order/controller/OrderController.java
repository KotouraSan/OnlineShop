package uz.ksan.backend.order.controller;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.order.model.OrderEntity;
import uz.ksan.backend.order.repository.OrderRepository;
import uz.ksan.backend.order.service.OrderService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/orders/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderEntity order) {
        orderService.saveOrder(order);
        return "Order created";
    }

    @DeleteMapping("{trackingNumber}")
    public String deleteOrder(@PathVariable String trackingNumber) {
        orderService.deleteOrderByTrackingNumber(trackingNumber);
        return "Order deleted";
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("customer/{fullName}")
    public ResponseEntity<List<OrderEntity>> findAllOrders(@PathVariable String fullName) {
        return ResponseEntity.ok(orderService.findAllOrdersByCustomer(fullName));
    }
}
