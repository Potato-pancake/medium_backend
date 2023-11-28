package potato.medium.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import potato.medium.global.jwt.dto.TokenResponseDto;
import potato.medium.presentation.dto.user.UserLoginRequestDto;
import potato.medium.presentation.dto.user.UserRequestDto;
import potato.medium.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public Long signup(UserRequestDto userRequestDto) {
        if(userRepository.findByEmail(userRequestDto.email()).isPresent())
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");

        String password = passwordEncoder.encode(userRequestDto.password());
        return userRepository.save(userRequestDto.toEntity(password)).getId();
    }

    public TokenResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        return null;
    }
}
