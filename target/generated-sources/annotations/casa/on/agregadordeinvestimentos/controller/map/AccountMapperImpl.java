package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateAccountDto;
import casa.on.agregadordeinvestimentos.entity.Account;
import casa.on.agregadordeinvestimentos.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-21T11:03:47-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account DtoToAccount(CreateAccountDto dto, User user) {
        if ( dto == null && user == null ) {
            return null;
        }

        Account account = new Account();

        if ( dto != null ) {
            account.setDescription( dto.getDescription() );
        }
        account.setUser( user );

        return account;
    }
}
