package casa.on.agregadordeinvestimentos.controller;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateAccountDto;
import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.controller.DTO.UserUpdateDTO;
import casa.on.agregadordeinvestimentos.entity.User;
import casa.on.agregadordeinvestimentos.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO body){
        var user = service.createUser(body);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String useId){
        var user = service.getUserById(useId);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        var users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String useId,
                                               @RequestBody @Valid UserUpdateDTO body){
        service.updateUserById(useId, body);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteByid(@PathVariable("userId") String useId){
        service.deleteById(useId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<Void> createAccount(@PathVariable("userId") String useId, @RequestBody CreateAccountDto dto){
       service.createAccount(useId, dto);
       return ResponseEntity.ok().build();
    }
    

}
