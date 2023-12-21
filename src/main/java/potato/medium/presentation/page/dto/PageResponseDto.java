package potato.medium.presentation.page.dto;

import potato.medium.domain.page.Page;
import potato.medium.domain.user.User;

public record PageResponseDto(
        Long id,
        String title,
        User artist
) {
    public PageResponseDto(Page page) {
        this(
                page.getId(),
                page.getTitle(),
                page.getArtist()
        );
    }
}
