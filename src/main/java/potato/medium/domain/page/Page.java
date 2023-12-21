package potato.medium.domain.page;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import potato.medium.domain.user.User;

@Entity
@Getter
@NoArgsConstructor
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User artist;

    @Builder
    public Page(String title, String content, User artist){
        this.title = title;
        this.content = content;
        this.artist = artist;
    }
}
