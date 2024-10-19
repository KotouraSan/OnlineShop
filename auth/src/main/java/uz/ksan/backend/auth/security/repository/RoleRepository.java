package uz.ksan.backend.auth.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ksan.backend.auth.security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, uz.ksan.backend.auth.security.model.Role.ERole> {

}
