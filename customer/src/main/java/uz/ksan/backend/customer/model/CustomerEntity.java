package uz.ksan.backend.customer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity implements Serializable {

    @SequenceGenerator(name="yourSequenceGeneratorClient", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="yourSequenceGeneratorClient")
    @Id
    Long id;

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

}
