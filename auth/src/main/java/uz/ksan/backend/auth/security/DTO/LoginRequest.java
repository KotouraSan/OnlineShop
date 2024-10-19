package uz.ksan.backend.auth.security.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
