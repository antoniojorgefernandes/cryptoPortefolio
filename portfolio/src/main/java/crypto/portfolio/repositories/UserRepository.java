package crypto.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import crypto.portfolio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
