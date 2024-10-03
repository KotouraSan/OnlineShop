package uz.ksan.backend.customer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shop implements Serializable {

    @ColumnTransformer(write = "LOWER(?)")
    String shopName;
    @ColumnTransformer(write = "LOWER(?)")
    String country;
    @ColumnTransformer(write = "LOWER(?)")
    String city;
    @ColumnTransformer(write = "LOWER(?)")
    String email;
}
