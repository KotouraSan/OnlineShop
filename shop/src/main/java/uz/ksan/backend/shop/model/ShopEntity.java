package uz.ksan.backend.shop.model;

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
@Entity
@Table(name = "shop")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopEntity implements Serializable {
    @SequenceGenerator(name="yourSequenceGeneratorClient", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="yourSequenceGeneratorClient")
    @Id
    Long id;

    @ColumnTransformer(write = "LOWER(?)")
    String shopName;
    @ColumnTransformer(write = "LOWER(?)")
    String localAddress;
    String phoneNumber;
    @ColumnTransformer(write = "LOWER(?)")
    String country;
    @ColumnTransformer(write = "LOWER(?)")
    String city;
    @ColumnTransformer(write = "LOWER(?)")
    String email;
    int rating;


}
