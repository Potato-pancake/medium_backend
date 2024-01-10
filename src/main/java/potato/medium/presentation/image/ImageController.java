package potato.medium.presentation.image;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import potato.medium.service.image.ImageService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/{artistName}")
    public String save(@PathVariable("artistName") String artistName, @RequestBody MultipartFile file) throws IOException {
        return imageService.saveImage(artistName, file);
    }
}
