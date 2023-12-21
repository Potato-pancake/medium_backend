package potato.medium.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import potato.medium.domain.user.role.Role;
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

    @Builder
    public User(String id, String password, String email, String name, String contact, String address, String regiNumber, String bigGenre, String detailGenre, String organization) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.regiNumber = regiNumber;
        this.bigGenre = bigGenre;
        this.detailGenre = detailGenre;
        this.organization = organization;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
