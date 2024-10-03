package uz.ksan.backend.order.model;

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
@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity implements Serializable {

    @SequenceGenerator(name="yourSequenceGeneratorClient", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="yourSequenceGeneratorClient")
    @Id
    Long id;

    String trackingNumber;
    double discount;
    double totalPrice;
    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            orderDate = LocalDate.now();  // Установка сегодняшней даты
        }
    }
    LocalDate orderDate;
}
