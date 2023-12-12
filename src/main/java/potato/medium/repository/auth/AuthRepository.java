package potato.medium.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import potato.medium.domain.user.User;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String Id);
}
