package ru.library.controlers;


import org.springframework.web.bind.annotation.*;
import ru.library.common.Response;
import ru.library.models.auth.AuthRequest;
import ru.library.models.auth.AuthResponse;
import ru.library.services.AuthService;
import ru.library.security.TokenHandler;
import ru.library.services.UserService;


@RestController
@RequestMapping("/api/auth/")
public class AuthControler {

    private final UserService userService;
    private final TokenHandler tokenHandler;
    private final AuthService authService;


    public AuthControler(UserService userService, TokenHandler tokenHandler, AuthService authService) {
        this.userService = userService;
        this.tokenHandler = tokenHandler;
        this.authService = authService;
    }


    @PostMapping
    public Response<AuthResponse> get(@RequestBody AuthRequest request) {
        return Response.from(() -> authService.chekUsernameAndPassword(request));
    }
}
