package potato.medium.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import potato.medium.domain.user.User;

@Repository
public interface AuthRepository extends JpaRepository<User, String> {

}
