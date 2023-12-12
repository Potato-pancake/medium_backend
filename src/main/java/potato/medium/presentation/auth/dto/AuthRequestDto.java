package potato.medium.presentation.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import potato.medium.domain.user.User;
import potato.medium.global.security.role.Role;

@Getter
@NoArgsConstructor
public class AuthRequestDto{
    private String id;
    private String password;
    private String email;
    private String name;
    private String contact;
    private String address;
    private String regiNumber;
    private String bigGenre;
    private String detailGenre;
    private String organization;
    private String role;

    public User toEntity(String password, Role role) {
        return new User(this, password, role);
    }
}
