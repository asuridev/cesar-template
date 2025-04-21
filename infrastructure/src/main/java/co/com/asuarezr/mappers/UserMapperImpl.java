package co.com.asuarezr.mappers;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.dtos.UpdateUserDto;
import co.com.asuarezr.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{

  @Override
  public UserEntity toUserEntity(CreateUserDto userDto) {
    return new UserEntity(
            null,
            userDto.name(),
            userDto.lastname(),
            userDto.email()
    );
  }

  @Override
  public ResponseUserDto toResponseUserDto(UserEntity userEntity) {
    return new ResponseUserDto(
            userEntity.getName(),
            userEntity.getLastName(),
            userEntity.getEmail()
    );
  }

  @Override
  public UserEntity merge(UserEntity userEntity, UpdateUserDto updateUserDto) {
     String id = userEntity.getId();
     String name = userEntity.getName();
     String lastName = userEntity.getLastName() ;
     String email = userEntity.getEmail();
     if(updateUserDto.name() != null){
        name = updateUserDto.name();
     }
     if(updateUserDto.lastname() != null){
        lastName = updateUserDto.lastname();
     }
     if(updateUserDto.email() != null){
        email = updateUserDto.email();
     }

    return new UserEntity(id, name, lastName, email);
  }

}
