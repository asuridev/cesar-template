package co.com.asuarezr.repositories;

import co.com.asuarezr.dtos.CreateUserDto;

public interface UserRepository {
  public CreateUserDto save(CreateUserDto createUserDto);
}
