package uz.ksan.backend.auth.security.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import uz.ksan.backend.auth.security.model.Role;
import uz.ksan.backend.auth.security.model.User;
import uz.ksan.backend.auth.security.repository.RoleRepository;
import uz.ksan.backend.auth.security.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public User saveUser(User user, Set<String> strRoles) {
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            uz.ksan.backend.auth.security.model.Role userRole = roleRepository.findById(Role.ERole.ROLE_USER)
                    .orElseThrow(() ->
                            new RuntimeException("Роль не найдена"));
            roles.add(userRole);
        }
        else {
            strRoles.forEach(role -> {
                switch (role.toLowerCase()) {
                    case "admin":
                        uz.ksan.backend.auth.security.model.Role adminRole = roleRepository.findById(Role.ERole.ROLE_ADMIN)
                                .orElseThrow(() ->
                                        new RuntimeException("Роль не найдена"));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleRepository.findById(Role.ERole.ROLE_USER)
                                .orElseThrow(() ->
                                        new RuntimeException("Роль не найдена"));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
