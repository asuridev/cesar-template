package co.com.asuarezr;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public CreateUserDto create( CreateUserDto createUserDto){
    return this.userRepository.save(createUserDto);
  }
}
