package co.com.asuarezr.repositories;

import co.com.asuarezr.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserEntity, String> {

}
