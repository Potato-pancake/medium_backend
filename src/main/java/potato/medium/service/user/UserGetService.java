package potato.medium.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import potato.medium.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;
}
