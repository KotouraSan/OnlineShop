package uz.ksan.backend.auth.security.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @SequenceGenerator(name="yourSequenceGeneratorClient", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="yourSequenceGeneratorClient")
    @Id
    Long id;

    private String name;
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles = new HashSet<>();

}
