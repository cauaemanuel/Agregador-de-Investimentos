package casa.on.agregadordeinvestimentos.service;

import casa.on.agregadordeinvestimentos.controller.DTO.UserDTO;
import casa.on.agregadordeinvestimentos.controller.map.UserMapper;
import casa.on.agregadordeinvestimentos.entity.User;
import casa.on.agregadordeinvestimentos.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import org.mapstruct.factory.Mappers;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    private UserRepository repository;

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    private UserService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(UserRepository.class);
        mapper = Mappers.getMapper(UserMapper.class);
        service = new UserService(repository, mapper);
    }

    @Nested
    class createUser{

        @Test
        @DisplayName("Should create a user with success")
        void shouldCreaterAUser(){
            //arrange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "user@gmail.com",
                    "123",
                    Instant.now(),
                    null
            );

            doReturn(user).when(repository).save(userArgumentCaptor.capture());
            var input = new UserDTO("username",
                    "user@gmail.com",
                    "123");

            //act
            var output = service.createUser(input);

            //assert
            var userCaptured = userArgumentCaptor.getValue();

            assertNotNull(output);
            assertEquals(input.username(), userCaptured.getUsername());
            assertEquals(input.email(), userCaptured.getEmail());
            assertEquals(input.password(), userCaptured.getPassword());
        }

        @Test
        @DisplayName("Should throw exception when error occurs")
        void shouldThrowExceptionWhenErrorOccurs(){

            //arrange

            doReturn(new RuntimeException()).when(repository).save(any());
            var input = new UserDTO("username",
                    "user@gamil.com",
                    "123");

            //act e Assert
            assertThrows(RuntimeException.class, () -> service.createUser(input));

        }


    }

    @Nested
    class getUserById{

    }

    @Nested
    class UserMapperTest{

    }
}