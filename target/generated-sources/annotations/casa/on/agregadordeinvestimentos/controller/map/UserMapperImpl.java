package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.controller.DTO.UserUpdateDTO;
import casa.on.agregadordeinvestimentos.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-11T23:17:32-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User UserDTOtoUser(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( dto.username() );
        user.setEmail( dto.email() );
        user.setPassword( dto.password() );

        return user;
    }

    @Override
    public void updateUserFromDto(UserUpdateDTO dto, User user) {
        if ( dto == null ) {
            return;
        }

        if ( dto.username() != null ) {
            user.setUsername( dto.username() );
        }
        if ( dto.password() != null ) {
            user.setPassword( dto.password() );
        }
    }
}
