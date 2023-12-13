package potato.medium.presentation.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import potato.medium.global.jwt.dto.TokenResponseDto;
import potato.medium.presentation.auth.dto.UserLoginRequestDto;
import potato.medium.presentation.auth.dto.AuthRequestDto;
import potato.medium.service.auth.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup (@RequestBody AuthRequestDto requestDto) {
        return authService.signup(requestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody UserLoginRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
}
