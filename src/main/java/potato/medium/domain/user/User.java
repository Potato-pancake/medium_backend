package potato.medium.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import potato.medium.presentation.user.dto.UserRequestDto;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String address;

    @Builder
    public User(UserRequestDto userRequestDto, String password) {
        this.id = userRequestDto.id();
        this.password = password;
        this.email = userRequestDto.email();
        this.name = userRequestDto.name();
        this.contact = userRequestDto.contact();
        this.address = userRequestDto.address();
    }
}
