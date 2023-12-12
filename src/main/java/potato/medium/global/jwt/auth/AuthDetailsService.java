package potato.medium.global.jwt.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import potato.medium.repository.auth.AuthRepository;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final AuthRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(Long.valueOf(username))
                .map(AuthDetails::new)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));
    }
}
