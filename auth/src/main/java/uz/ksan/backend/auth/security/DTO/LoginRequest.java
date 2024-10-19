package uz.ksan.backend.auth.security.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
