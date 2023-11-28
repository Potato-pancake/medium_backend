package potato.medium.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import potato.medium.domain.user.User;
import potato.medium.global.jwt.dto.TokenResponseDto;
import potato.medium.global.jwt.util.JwtUtil;
import potato.medium.presentation.dto.user.UserLoginRequestDto;
import potato.medium.presentation.dto.user.UserRequestDto;
import potato.medium.repository.user.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public String signup(UserRequestDto userRequestDto) {
        if(userRepository.findById(userRequestDto.id()).isPresent())
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");

        String password = passwordEncoder.encode(userRequestDto.password());
        return userRepository.save(userRequestDto.toEntity(password)).getId();
    }

    public TokenResponseDto login(UserLoginRequestDto userRequestDto) {
        Optional<User> user = userRepository.findById(userRequestDto.id());
        if(user.isEmpty())
            throw new IllegalArgumentException("올바르지 않은 아이디입니다.");
        if(!passwordEncoder.matches(userRequestDto.password(), user.get().getPassword()))
            throw new IllegalArgumentException("올바르지 않은 비밀번호입니다.");

        return new TokenResponseDto(jwtUtil.generateToken(user.get().getId()));
    }
}
