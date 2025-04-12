package co.com.asuarezr;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.dtos.UpdateUserDto;
import co.com.asuarezr.handlerExceptions.customExceptions.NotFoundException;
import co.com.asuarezr.handlerLogs.annotations.LogExceptions;
import co.com.asuarezr.handlerLogs.annotations.LogTimer;
import co.com.asuarezr.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public ResponseUserDto createUser(CreateUserDto createUserDto){
    return this.userRepository.save(createUserDto);
  }

  public List<ResponseUserDto> findAllUsers(){
    return this.userRepository.findAll();
  }

  public ResponseUserDto findUserById(String id){
    return this.userRepository.findOne(id);
  }

  public ResponseUserDto updateUser(UpdateUserDto updateUserDto, String id){
     return userRepository.update(updateUserDto, id);
  }

  public void deleteUser(String id){
    userRepository.delete(id);
  }

}
