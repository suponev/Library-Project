package ru.library.controlers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.library.common.Response;
import ru.library.services.FileUploadService;

@RestController
@RequestMapping("/api/")
public class FileControler {

    private final FileUploadService fileUploadService;

    public FileControler(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("publish_image")
    public Response<Long> savePublishImage(@RequestBody MultipartFile file) {
        return Response.from(() -> fileUploadService.savePublishImage(file));
    }

    @GetMapping("publish_image/{image_id}")
    public Response<String> getPublishImage(@PathVariable("image_id") Long id) {
        return Response.from(() -> fileUploadService.getPublishImage(id));
    }

    @PostMapping("avatar")
    public Response<Long> addAvatar(@RequestBody MultipartFile file) {
        return Response.from(() -> fileUploadService.savePublishImage(file));
    }
}
