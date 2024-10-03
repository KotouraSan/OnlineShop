package uz.ksan.backend.order.service;

import uz.ksan.backend.order.model.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void saveOrder(OrderEntity order);
    void deleteOrderByTrackingNumber(String TrackingNumber);
    List<OrderEntity> findAllOrders();
    List<OrderEntity> findAllOrdersByCustomer(String fullName);
}
