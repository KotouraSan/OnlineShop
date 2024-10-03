package uz.ksan.backend.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.customer.model.CustomerEntity;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findAll();
    CustomerEntity findByFullName(String fullName);
}
