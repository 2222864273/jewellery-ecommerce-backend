package za.co.jewellerysystem.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import za.co.jewellerysystem.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


