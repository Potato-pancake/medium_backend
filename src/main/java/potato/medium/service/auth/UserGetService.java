package potato.medium.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import potato.medium.domain.user.User;
import potato.medium.domain.user.role.Role;
import potato.medium.repository.auth.AuthRepository;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final AuthRepository authRepository;

    public User getUser() {
        String id = getUserId();
        return authRepository.findById(id).orElseThrow();
    }

    public String getUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public Role getUserRole() {
        return getUser().getRole();
    }
}
