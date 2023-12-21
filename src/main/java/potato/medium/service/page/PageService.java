package potato.medium.service.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import potato.medium.domain.page.Page;
import potato.medium.presentation.page.dto.PageRequestDto;
import potato.medium.presentation.page.dto.PageResponseDto;
import potato.medium.repository.page.PageRepository;
import potato.medium.service.auth.UserGetService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;
    private final UserGetService userGetService;

    public Long createPage(PageRequestDto pageRequestDto) {
        Page page = Page.builder()
                .title(pageRequestDto.title())
                .content(pageRequestDto.content())
                .artist(userGetService.getUser())
                .build();

        return pageRepository.save(page).getId();
    }

    public List<PageResponseDto> getPages() {
        return pageRepository.findAll().stream()
                .map(PageResponseDto::new).toList();
    }


}
