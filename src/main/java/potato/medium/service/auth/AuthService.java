package potato.medium.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import potato.medium.domain.user.User;
import potato.medium.global.jwt.dto.TokenResponseDto;
import potato.medium.global.jwt.util.JwtUtil;
import potato.medium.global.security.role.Role;
import potato.medium.presentation.auth.dto.UserLoginRequestDto;
import potato.medium.presentation.auth.dto.AuthRequestDto;
import potato.medium.repository.auth.AuthRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final AuthRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String signup(AuthRequestDto requestDto) {
        if(userRepository.findById(requestDto.getId()).isPresent())
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        String password = passwordEncoder.encode(requestDto.getPassword());

        Role role = null;
        String requestRole = requestDto.getRole();
        switch (requestRole) {
            case "admin" -> role = Role.ADMIN;
            case "person" -> role = Role.PERSON;
            case "artist" -> role = Role.ARTIST;
            case "company" -> role = Role.COMPANY;
        }

        return userRepository.save(requestDto.toEntity(password, role)).getId();
    }

    public TokenResponseDto login(UserLoginRequestDto requestDto) {
        Optional<User> user = userRepository.findById(requestDto.id());
        if(user.isEmpty())
            throw new IllegalArgumentException("올바르지 않은 아이디입니다.");
        if(!passwordEncoder.matches(requestDto.password(), user.get().getPassword()))
            throw new IllegalArgumentException("올바르지 않은 비밀번호입니다.");

        return new TokenResponseDto(jwtUtil.generateToken(user.get().getId()));
    }
}
