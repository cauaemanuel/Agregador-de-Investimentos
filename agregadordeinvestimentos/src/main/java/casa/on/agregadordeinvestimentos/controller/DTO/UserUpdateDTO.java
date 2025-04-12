package casa.on.agregadordeinvestimentos.controller.DTO;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO (@NotBlank String username, @NotBlank String password){
}
