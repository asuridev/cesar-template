package co.com.asuarezr.repositories;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserCrudRepository userCrudRepository;

  public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
    this.userCrudRepository = userCrudRepository;
  }

  @Override
  public CreateUserDto save(CreateUserDto createUserDto) {
    UserEntity createUserEntity = new UserEntity(
            null,
            createUserDto.name(),
            createUserDto.lastname(),
            createUserDto.lastname()
    );
    UserEntity newEntity = userCrudRepository.save(createUserEntity);
    return new CreateUserDto(
            newEntity.getName(),
            newEntity.getLastName(),
            newEntity.getEmail()
    );
  }
}
