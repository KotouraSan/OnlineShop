package uz.ksan.backend.customer.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.customer.model.CustomerEntity;
import uz.ksan.backend.customer.model.FullCustomerResponse;
import uz.ksan.backend.customer.repository.CustomerRepository;
import uz.ksan.backend.customer.service.OrderClient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Primary
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements uz.ksan.backend.customer.service.CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderClient orderClient;

    @Override
    public void saveCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String fullName) {
        var foundClient = findByFullName(fullName)
                .orElseThrow(() -> new NoSuchElementException("No customer found with Name: " + fullName));
        customerRepository.delete(foundClient);
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public Optional<CustomerEntity> findByFullName(String fullName) {
        return Optional.ofNullable(customerRepository.findByFullName(fullName));
    }




    public FullCustomerResponse findOrderByCustomer(String fullName){
        var foundClient = findByFullName(fullName)
                .orElseThrow(() -> new NoSuchElementException("No customer found with Name: " + fullName));
        var orders = orderClient.findOrdersForCustomer(fullName);
        return FullCustomerResponse.builder()
                .fullName(foundClient.getFullName())
                .phoneNumber(foundClient.getPhoneNumber())
                .email(foundClient.getEmail())
                .country(foundClient.getCountry())
                .city(foundClient.getCity())
                .postalCode(foundClient.getPostalCode())
                .orders(orders)
                .build();
    }

    @Override
    public List<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }
}
