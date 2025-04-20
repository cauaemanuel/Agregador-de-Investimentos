package casa.on.agregadordeinvestimentos.service;

import casa.on.agregadordeinvestimentos.controller.DTO.*;
import casa.on.agregadordeinvestimentos.controller.map.AccountMapper;
import casa.on.agregadordeinvestimentos.controller.map.UserMapper;
import casa.on.agregadordeinvestimentos.entity.Account;
import casa.on.agregadordeinvestimentos.entity.BillingAddress;
import casa.on.agregadordeinvestimentos.entity.User;
import casa.on.agregadordeinvestimentos.repository.AccountRepository;
import casa.on.agregadordeinvestimentos.repository.BillingAddressRepository;
import casa.on.agregadordeinvestimentos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.io.IO.println;

@Service
public class UserService {

    private UserMapper mapper;
    private UserRepository repository;
    private AccountMapper AcMapper;
    private AccountRepository accountRepository;

    private BillingAddressRepository billingAddressRepository;

    public UserService(UserMapper mapper, UserRepository repository, AccountMapper acMapper, AccountRepository accountRepository, BillingAddressRepository billingAddressRepository) {
        this.mapper = mapper;
        this.repository = repository;
        AcMapper = acMapper;
        this.accountRepository = accountRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public User createUser(UserDTO dto){
        var entity = mapper.UserDTOtoUser(dto);
        return repository.save(entity);
    }

    public Optional<User> getUserById(String userid){
        return repository.findById(UUID.fromString(userid));
    }

    public void deleteById(String userid){
       var id = UUID.fromString(userid);
       var userExists = repository.existsById(id);

       if(userExists){
           repository.deleteById(id);
       }
    }

    public User updateUserById(String userId,
                               UserUpdateDTO body ){

        var id = UUID.fromString(userId);
        var userEntity = repository.findById(id);

        if (userEntity.isPresent()){

            var user = userEntity.get();
            mapper.updateUserFromDto(body, user);

            return repository.save(user);
        }
        return null;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public void createAccount(String useId, CreateAccountDto dto) {
       var user = repository.findById(UUID.fromString(useId))
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));

       var account = AcMapper.DtoToAccount(dto, user);

       var accountCreated = accountRepository.save(account);
       var billingAddress = BillingAddress.of(new BillingAddressCreateByAccount(account,
               dto.getStreet(),
               dto.getNumber()));

       billingAddressRepository.save(billingAddress);

    }

    public List<AccountResponseDto> listAccounts(String useId) {
        var user = repository.findById(UUID.fromString(useId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));

        return user.getAccounts()
                .stream()
                .map(r -> new AccountResponseDto(r.getAccountId().toString(), r.getDescription()))
                .toList();
    }
}
