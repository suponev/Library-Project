package ru.library.controlers;

import org.springframework.web.bind.annotation.*;
import ru.library.common.Response;
import ru.library.models.Publication;
import ru.library.services.PublicationServise;

@RestController
@RequestMapping("/api/publish/")
public class PublicationControler {
    private final PublicationServise servise;

    public PublicationControler(PublicationServise servise) {
        this.servise = servise;
    }

    @PostMapping
    public Response publish(@RequestBody Publication publication) {
        return Response.from(() -> servise.savePublication(publication));
    }

}
