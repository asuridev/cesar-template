package co.com.asuarezr.repositories;

import co.com.asuarezr.dtos.CreateUserDto;
import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.dtos.UpdateUserDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  public ResponseUserDto save(CreateUserDto createUserDto);
  public List<ResponseUserDto> findAll();
  public ResponseUserDto findOne(String id);
  public ResponseUserDto update(UpdateUserDto updateUserDto, String id);
  public void delete(String id);
}
