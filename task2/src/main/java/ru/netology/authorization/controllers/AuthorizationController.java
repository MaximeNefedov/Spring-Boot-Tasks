package ru.netology.authorization.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorization.access_rights.Authorities;
//import ru.netology.authorization.annotations.UserAnnotation;
import ru.netology.authorization.model.User;
import ru.netology.authorization.services.AuthorizationService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

//    @GetMapping("/authorize")
//    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
//        return service.getAuthorities(user, password);
//    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        return service.getAuthorities(user);
    }
}
