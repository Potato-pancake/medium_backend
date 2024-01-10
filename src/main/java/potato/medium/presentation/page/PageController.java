package potato.medium.presentation.page;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import potato.medium.presentation.page.dto.PageRequestDto;
import potato.medium.presentation.page.dto.PageResponseDto;
import potato.medium.service.page.PageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/page")
public class PageController {

    private final PageService pageService;

    @PostMapping
    public Long create(@RequestBody PageRequestDto pageRequestDto, @RequestPart(required = false) MultipartFile file) {
        return pageService.createPage(pageRequestDto);
    }

    @GetMapping
    public List<PageResponseDto> get() {
        return pageService.getPages();
    }
}
