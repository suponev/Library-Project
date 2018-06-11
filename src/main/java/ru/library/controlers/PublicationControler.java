package ru.library.controlers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.library.common.Response;
import ru.library.models.PublicationFilter;
import ru.library.models.PublicationRequest;
import ru.library.models.PublicationResponse;
import ru.library.models.Vote;
import ru.library.services.PublicationService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pub/")
public class PublicationControler {
    private final PublicationService service;

    public PublicationControler(PublicationService service) {
        this.service = service;
    }

    @PostMapping
    public Response<PublicationResponse> save(@RequestBody PublicationRequest publication) {
        return Response.from(() -> {
            return service.savePublication(publication);
        });
    }

    @PostMapping("filter")
    public Response<List<PublicationResponse>> getByFilter(@RequestBody PublicationFilter filter) {
        return Response.from(() -> service.getByFilter(filter));
    }

    @GetMapping("image/{file_id}")
    public ResponseEntity getFileRate(@PathVariable("file_id") Long idJpeg) {
        // Long id = Long.valueOf(idJpeg.substring(idJpeg.indexOf(".")));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("image/jpeg"))
                .body(new ByteArrayResource(service.getImage(idJpeg).getBytes()));
    }

    @PostMapping("vote")
    public Response vote(@RequestBody Vote vote) {

        return Response.from(() -> service.vote(vote));
    }

}
