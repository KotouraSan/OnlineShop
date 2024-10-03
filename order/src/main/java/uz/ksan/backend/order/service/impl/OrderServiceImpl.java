package uz.ksan.backend.order.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.order.exceptions.NotFoundException;
import uz.ksan.backend.order.model.OrderEntity;
import uz.ksan.backend.order.repository.OrderRepository;
import uz.ksan.backend.order.service.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Primary
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements uz.ksan.backend.order.service.OrderService {

    OrderRepository orderRepository;

    @Override
    public void saveOrder(OrderEntity order) {
        order.setOrderDate(LocalDate.now());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrderByTrackingNumber(String trackingNumber) {
        var foundOrder = findOrderByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new NotFoundException("Order not found"));
        orderRepository.delete(foundOrder);
    }

    public Optional<OrderEntity> findOrderByTrackingNumber(String trackingNumber){
        return (orderRepository.findOrderByTrackingNumber(trackingNumber));
    }

    public List<OrderEntity> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> findAllOrdersByCustomer(String fullName) {
        return orderRepository.findAllOrdersByFullName(fullName);
    }
}
