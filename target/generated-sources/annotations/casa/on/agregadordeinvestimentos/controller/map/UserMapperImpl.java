package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-11T21:24:00-0300",
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
}
