package potato.medium.presentation.auth.dto;

public record UserLoginRequestDto(
        String id,
        String password
) {
}
