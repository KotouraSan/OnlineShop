package uz.ksan.backend.customer.service;

import uz.ksan.backend.customer.model.CustomerEntity;
import uz.ksan.backend.customer.model.FullCustomerResponse;

public interface CustomerService {
    void saveCustomer(CustomerEntity customer);
    void deleteCustomer(String customerName);
    CustomerEntity updateCustomer(CustomerEntity customer);
    FullCustomerResponse findClientWithOrders(String fullName);
}
