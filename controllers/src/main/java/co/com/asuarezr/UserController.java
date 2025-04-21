package co.com.asuarezr;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.dtos.UpdateUserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseUserDto create(@RequestBody @Valid CreateUserDto createUserDto){
    return this.userService.createUser(createUserDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ResponseUserDto> findAll(){
    return this.userService.findAllUsers();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public ResponseUserDto findOne(@PathVariable("id") String id){
    return this.userService.findUserById(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PatchMapping("/{id}")
  public ResponseUserDto update(@Valid @RequestBody UpdateUserDto updateUserDto, @PathVariable("id") String id){
    return this.userService.updateUser(updateUserDto, id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void remove(@PathVariable("id") String id){
     this.userService.deleteUser(id);
  }


}
