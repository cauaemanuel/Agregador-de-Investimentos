package casa.on.agregadordeinvestimentos.service;

import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.controller.DTO.UserUpdateDTO;
import casa.on.agregadordeinvestimentos.controller.map.UserMapper;
import casa.on.agregadordeinvestimentos.entity.User;
import casa.on.agregadordeinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
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
}
