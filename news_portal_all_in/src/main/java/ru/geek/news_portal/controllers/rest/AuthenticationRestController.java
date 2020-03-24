package ru.geek.news_portal.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import ru.geek.news_portal.base.entities.Role;
import ru.geek.news_portal.base.entities.User;
import ru.geek.news_portal.dto.AuthDto;
import ru.geek.news_portal.jwt.JwtTokenProvider;
import ru.geek.news_portal.services.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Stanislav Ryzhkov
 * created on 21.03.2020
 */

@RestController
@RequestMapping(value = "api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationRestController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtTokenProvider tokenProvider;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTokenProvider(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping
    public String auth(@Valid @RequestBody AuthDto auth) {
        try {
            String username = auth.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, auth.getPassword()));
            User user = userService.findByUsername(username);
            return tokenProvider.createToken(username, (List<Role>) user.getRoles());
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Неправильное имя пользователя или пароль");
        }
    }
}
