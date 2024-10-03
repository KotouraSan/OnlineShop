package uz.ksan.backend.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.order.model.OrderEntity;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findOrderByTrackingNumber(String trackingNumber);
}
