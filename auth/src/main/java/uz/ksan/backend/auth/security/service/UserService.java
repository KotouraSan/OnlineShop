package uz.ksan.backend.auth.security.service;

import uz.ksan.backend.auth.security.model.User;

import java.util.Set;

public interface UserService {
    User saveUser(User user, Set<String> strRoles);
}
