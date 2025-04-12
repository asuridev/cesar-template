package co.com.asuarezr.repositories;

import co.com.asuarezr.dtos.ResponseUserDto;
import co.com.asuarezr.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UserEntity, String> {

  @Query("""
          SELECT new co.com.asuarezr.dtos.ResponseUserDto(
            u.name,
            u.lastName,
            u.email
          ) FROM UserEntity u
          """)
  List<ResponseUserDto> findAllUsers();

  @Query("""
          SELECT new co.com.asuarezr.dtos.ResponseUserDto(
            u.name,
            u.lastName,
            u.email
          ) FROM UserEntity u
          WHERE u.id =:id
          """)
  Optional<ResponseUserDto> findUserById(@Param("id") String id);

}
