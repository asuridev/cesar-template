package co.com.asuarezr.mappers;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.dtos.UpdateUserDto;
import co.com.asuarezr.entities.UserEntity;

public interface UserMapper {

  UserEntity toUserEntity(CreateUserDto userDto);

  ResponseUserDto toResponseUserDto(UserEntity userEntity);

  UserEntity merge(UserEntity userEntity, UpdateUserDto updateUserDto);
}
