package uz.ksan.backend.customer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullCustomerResponse implements Serializable {

    @ColumnTransformer(write = "LOWER(?)")
    String fullName;
    @ColumnTransformer(write = "LOWER(?)")
    String phoneNumber;
    @ColumnTransformer(write = "LOWER(?)")
    String email;
    @ColumnTransformer(write = "LOWER(?)")
    String country;
    @ColumnTransformer(write = "LOWER(?)")
    String city;
    Long postalCode;

    List<Order> orders;
    List<Shop> shops;

}
