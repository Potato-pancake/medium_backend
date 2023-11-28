package potato.medium.presentation.dto.user;

import potato.medium.domain.user.User;

public record UserRequestDto(
        String id,
        String password,
        String email,
        String name,
        String contact,
        String address
) {
    public User toEntity(String password) {
        return User.builder()
                .userRequestDto(this)
                .password(password)
                .build();
    }
}
