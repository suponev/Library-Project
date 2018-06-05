package ru.library.controlers;

import org.springframework.web.bind.annotation.*;
import ru.library.common.Response;
import ru.library.entity.UserEntity;
import ru.library.models.Publication;
import ru.library.models.PublicationFilter;
import ru.library.models.PublicationRequest;
import ru.library.models.PublicationResponse;
import ru.library.services.PublicationServise;

import java.util.List;

@RestController
@RequestMapping("/api/pub/")
public class PublicationControler {
    private final PublicationServise servise;

    public PublicationControler(PublicationServise servise) {
        this.servise = servise;
    }

    @PostMapping
    public Response save(@RequestBody PublicationRequest publication) {
        return Response.from(() -> servise.savePublication(publication));
    }

    @PostMapping("/filter")
    public Response<List<PublicationResponse>> getByFilter(@RequestBody PublicationFilter filter) {
        return Response.from(() -> servise.getByFilter(filter));
    }
}
