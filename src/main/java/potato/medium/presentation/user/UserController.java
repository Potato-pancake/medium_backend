package potato.medium.presentation.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import potato.medium.global.jwt.dto.TokenResponseDto;
import potato.medium.presentation.dto.user.UserLoginRequestDto;
import potato.medium.presentation.dto.user.UserRequestDto;
import potato.medium.service.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup (@RequestBody UserRequestDto userSignupRequestDto) {
        return userService.signup(userSignupRequestDto);
    }

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody UserLoginRequestDto userRequestDto) {
        return userService.login(userRequestDto);
    }
}
