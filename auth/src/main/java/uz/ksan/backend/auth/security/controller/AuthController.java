package uz.ksan.backend.auth.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ksan.backend.auth.security.DTO.JwtResponse;
import uz.ksan.backend.auth.security.DTO.LoginRequest;
import uz.ksan.backend.auth.security.DTO.SignUpRequest;
import uz.ksan.backend.auth.security.DTO.UserDTO;
import uz.ksan.backend.auth.security.jwt.JwtUtils;
import uz.ksan.backend.auth.security.mapper.UserMapper;
import uz.ksan.backend.auth.security.model.User;
import uz.ksan.backend.auth.security.repository.RoleRepository;
import uz.ksan.backend.auth.security.repository.UserRepository;
import uz.ksan.backend.auth.security.service.service.UserDetailsImpl;
import uz.ksan.backend.auth.security.service.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtUtils jwtUtils;

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @PostMapping("/signin")
    @Operation(summary = "Аутентификация пользователя", description = "Вход пользователя в систему")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        UserDTO userDTO = userMapper.toUserDTO(userRepository.findByUsername(userDetails.getUsername()).orElseThrow());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    @Operation(summary = "Регистрация пользователя", description = "создание нового пользователя")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Exception("такой юзернейм уже существует"));
        }
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Exception("такой email уже используется"));
        }

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        Set<String> strRoles = signUpRequest.getRoles();
        userService.saveUser(user, strRoles);

        return ResponseEntity.ok("Пользователь зарегестрирован!");

    }


}
