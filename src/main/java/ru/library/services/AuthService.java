package ru.library.services;

import lombok.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.library.models.User;
import ru.library.models.auth.AuthRequest;
import ru.library.models.auth.AuthResponse;
import ru.library.security.TokenHandler;
import ru.library.security.UserAuthentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Service
public class AuthService {
    private static final String AUTH_HEADER_NAME = "Authorization";
    private final TokenHandler tokenHandler;
    private final UserService userService;

    public AuthService(TokenHandler tokenHandler, UserService userService) {
        this.tokenHandler = tokenHandler;
        this.userService = userService;
    }

    public Optional<Authentication> getAuthentication(@NonNull HttpServletRequest request) {
        return Optional
                .ofNullable(request.getHeader(AUTH_HEADER_NAME))
                .flatMap(tokenHandler::extractUserName)
                .map(userService::getByUsername)
                .map(UserAuthentication::new);
    }

    public AuthResponse chekUsernameAndPassword(AuthRequest request) {
        AuthResponse response = new AuthResponse();
        //List l = userService.all();
        User user = userService.getByUsername(request.getUsername());
        if (user == null) {
            return response;
        } else {
            if (user.getPassword().equals(request.getPassword())) {
                response.setUsername(user.getUsername());
                response.setUserId(user.getId());
                response.setToken(tokenHandler.generateAccessToken(user.getUsername()));
                return response;
            } else {
                return response;
            }
        }
    }


}
