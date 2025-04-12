package casa.on.agregadordeinvestimentos.service;

import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.controller.map.UserMapper;
import casa.on.agregadordeinvestimentos.entity.User;
import casa.on.agregadordeinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserMapper mapper;
    private UserRepository repository;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User createUser(UserDTO dto){

        var entity = mapper.UserDTOtoUser(dto);
        return repository.save(entity);

    }

    public Optional<User> getUserById(String userid){
        return  repository.findById(UUID.fromString(userid));
    }
}
