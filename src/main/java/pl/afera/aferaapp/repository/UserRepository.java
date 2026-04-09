package pl.afera.aferaapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.afera.aferaapp.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
