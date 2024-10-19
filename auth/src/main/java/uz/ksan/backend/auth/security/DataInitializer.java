package uz.ksan.backend.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.ksan.backend.auth.security.model.Role;
import uz.ksan.backend.auth.security.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role userRole = new Role();
            userRole.setName(Role.ERole.valueOf("ROLE_USER"));
            roleRepository.save(userRole);

            Role adminRole = new Role();
            adminRole.setName(Role.ERole.valueOf("ROLE_ADMIN"));
            roleRepository.save(adminRole);
        }
    }
}
