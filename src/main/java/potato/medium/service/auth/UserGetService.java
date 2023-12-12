package potato.medium.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import potato.medium.repository.auth.AuthRepository;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final AuthRepository userRepository;
}
