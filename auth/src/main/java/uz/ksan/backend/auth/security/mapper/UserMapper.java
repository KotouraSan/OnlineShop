package uz.ksan.backend.auth.security.mapper;

import org.mapstruct.Mapper;
import uz.ksan.backend.auth.security.DTO.UserDTO;
import uz.ksan.backend.auth.security.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
