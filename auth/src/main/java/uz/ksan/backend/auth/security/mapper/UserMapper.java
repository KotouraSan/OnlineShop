package uz.ksan.backend.auth.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.ksan.backend.auth.security.DTO.UserDTO;
import uz.ksan.backend.auth.security.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Маппинг из User в UserDTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    UserDTO toUserDTO(User user);

    // Если метод toUser не используется, можно его удалить или игнорировать поле roles
    @Mapping(target = "roles", ignore = true)
    User toUser(UserDTO userDTO);
}
