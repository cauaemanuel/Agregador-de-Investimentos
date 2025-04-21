package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateAccountDto;
import casa.on.agregadordeinvestimentos.entity.Account;
import casa.on.agregadordeinvestimentos.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "user", source = "user")
    Account DtoToAccount(CreateAccountDto dto, User user);
}
