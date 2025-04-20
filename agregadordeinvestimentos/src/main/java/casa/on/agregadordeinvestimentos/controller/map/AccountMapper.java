package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateAccountDto;
import casa.on.agregadordeinvestimentos.entity.Account;
import casa.on.agregadordeinvestimentos.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Define explicitamente que o accountId será null
    @Mapping(target = "user", source = "user")  // Mapeia o 'user' do DTO para a entidade// Ignora a lista accountStocks
    Account DtoToAccount(CreateAccountDto dto, User user);
}
