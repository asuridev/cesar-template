package co.com.asuarezr;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserDto> findAll(){
    return null;
  }


  @PostMapping
  public CreateUserDto create(@RequestBody @Valid CreateUserDto createUserDto){
    return this.userService.createUser(createUserDto);
  }
}
