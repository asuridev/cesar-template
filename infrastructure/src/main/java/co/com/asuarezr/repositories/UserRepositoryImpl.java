package co.com.asuarezr.repositories;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.dtos.UpdateUserDto;
import co.com.asuarezr.entities.UserEntity;
import co.com.asuarezr.handlerExceptions.customExceptions.NotFoundException;
import co.com.asuarezr.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserCrudRepository userCrudRepository;
  private final UserMapper userMapper;

  public UserRepositoryImpl(
          UserCrudRepository userCrudRepository,
          UserMapper userMapper
  ) {
    this.userCrudRepository = userCrudRepository;
    this.userMapper = userMapper;
  }

  @Override
  public ResponseUserDto save(CreateUserDto createUserDto) {
    UserEntity newUser =   this.userCrudRepository.save(this.userMapper.toUserEntity(createUserDto));
    return this.userMapper.toResponseUserDto(newUser);
  }

  @Override
  public List<ResponseUserDto> findAll() {
    return this.userCrudRepository.findAllUsers();
  }

  @Override
  public ResponseUserDto findOne(String id) {
     return this.userCrudRepository.findUserById(id).orElseThrow(NotFoundException::new);
  }

  @Override
  public ResponseUserDto update(UpdateUserDto updateUserDto, String id) {
    UserEntity userEntity = this.userCrudRepository.findById(id).orElseThrow(NotFoundException::new);
    UserEntity userUpdated = this.userCrudRepository.save(this.userMapper.merge(userEntity, updateUserDto));
    return this.userMapper.toResponseUserDto(userUpdated);
  }

  @Override
  public void delete(String id) {
    this.userCrudRepository.deleteById(id);
  }

}
