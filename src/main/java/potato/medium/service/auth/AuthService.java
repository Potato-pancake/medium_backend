package potato.medium.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import potato.medium.domain.user.User;
import potato.medium.global.error.exception.ErrorCode;
import potato.medium.global.error.exception.MediumException;
import potato.medium.global.jwt.dto.TokenResponseDto;
import potato.medium.global.jwt.util.JwtUtil;
import potato.medium.domain.user.role.Role;
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
            throw new MediumException(ErrorCode.USER_ALREADY_REGISTERED);
        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = User.builder()
                .id(requestDto.getId())
                .password(password)
                .email(requestDto.getEmail())
                .name(requestDto.getName())
                .contact(requestDto.getContact())
                .address(requestDto.getAddress())
                .regiNumber(requestDto.getRegiNumber())
                .bigGenre(requestDto.getBigGenre())
                .detailGenre(requestDto.getDetailGenre())
                .organization(requestDto.getOrganization())
                .build();

        String requestRole = requestDto.getRole();
        switch (requestRole) {
            case "admin" -> user.setRole(Role.ADMIN);
            case "person" -> user.setRole(Role.PERSON);
            case "artist" -> user.setRole(Role.ARTIST);
            case "company" -> user.setRole(Role.COMPANY);
        }

        return userRepository.save(user).getId();
    }

    public TokenResponseDto login(UserLoginRequestDto requestDto) {
        Optional<User> user = userRepository.findById(requestDto.id());
        if(user.isEmpty())
            throw new MediumException(ErrorCode.USER_NOT_FOUND);
        if(!passwordEncoder.matches(requestDto.password(), user.get().getPassword()))
            throw new MediumException(ErrorCode.ILLEGAL_PASSWORD);

        return new TokenResponseDto(jwtUtil.generateToken(user.get().getId()));
    }
}
