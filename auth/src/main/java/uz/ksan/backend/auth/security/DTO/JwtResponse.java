package uz.ksan.backend.auth.security.DTO;


import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
public class JwtResponse {
    private String username;
    @Email
    private String email;
    private Set<String> roles;
    private String password;

    public JwtResponse(String jwt, Long id, String username, String email, List<String> roles) {

    }
}
