package co.com.asuarezr;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.handlerExceptions.customExceptions.NotFoundException;
import co.com.asuarezr.handlerExceptions.customExceptions.UnauthorizedException;
import co.com.asuarezr.handlerLogs.annotations.LogAfter;
import co.com.asuarezr.handlerLogs.annotations.LogExceptions;
import co.com.asuarezr.handlerLogs.annotations.LogTimer;
import co.com.asuarezr.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @LogTimer
  public CreateUserDto createUser( CreateUserDto createUserDto){
    //throw new UnauthorizedException();
    return this.userRepository.save(createUserDto);
  }
}
