package uz.ksan.backend.customer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order implements Serializable {

    String trackingNumber;
    double discount;
    double totalPrice;
    LocalDate orderDate;
    String fullName;


}
