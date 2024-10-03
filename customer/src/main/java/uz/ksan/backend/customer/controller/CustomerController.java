package uz.ksan.backend.customer.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import uz.ksan.backend.customer.model.CustomerEntity;
import uz.ksan.backend.customer.model.FullCustomerResponse;
import uz.ksan.backend.customer.repository.CustomerRepository;
import uz.ksan.backend.customer.service.CustomerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/customer/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private HandlerMapping resourceHandlerMapping;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody CustomerEntity customer) {
        customerService.saveCustomer(customer);
        return "Customer saved";
    }

    @DeleteMapping("{fullName}")
    public String deleteCustomer(@PathVariable String fullName) {
        customerService.deleteCustomer(fullName);
        return "Customer deleted";
    }

    @PutMapping
    public String updateCustomer(CustomerEntity customer) {
        customerService.updateCustomer(customer);
        return "Customer updated";
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("{fullName}")
    public ResponseEntity<FullCustomerResponse> findOrderByCustomer(@PathVariable String fullName) {
        return ResponseEntity.ok(customerService.findOrderByCustomer(fullName));
    }


}
