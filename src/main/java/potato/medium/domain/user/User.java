package potato.medium.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import potato.medium.global.security.role.Role;
import potato.medium.presentation.auth.dto.AuthRequestDto;

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

    private String regiNumber;

    private String bigGenre;

    private String detailGenre;

    private String organization;

    @Column(nullable = false)
    private Role role;

    public User(AuthRequestDto authRequestDto, String password, Role role) {
        id = authRequestDto.getId();
        this.password = password;
        email = authRequestDto.getEmail();
        name = authRequestDto.getName();
        contact = authRequestDto.getContact();
        address = authRequestDto.getAddress();
        regiNumber = authRequestDto.getRegiNumber();
        bigGenre = authRequestDto.getBigGenre();
        detailGenre = authRequestDto.getDetailGenre();
        organization = authRequestDto.getOrganization();
        this.role = role;
    }

}
