package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User UserDTOtoUser(UserDTO dto);

}
