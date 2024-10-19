package uz.ksan.backend.auth.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Enumerated(EnumType.STRING)
    private ERole name;

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }
}

