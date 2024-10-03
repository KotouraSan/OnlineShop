package uz.ksan.backend.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.ksan.backend.customer.model.Order;

import java.util.List;

@FeignClient(name = "orders-service", url = "http://localhost:8222/api/v1/orders/")
public interface OrderClient {
    @GetMapping("{fullName}")
    List<Order> findOrdersForClient(@PathVariable("fullName") String fullName);
}
