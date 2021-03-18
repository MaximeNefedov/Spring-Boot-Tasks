package ru.netology.authorization.services;

import org.springframework.stereotype.Service;
import ru.netology.authorization.access_rights.Authorities;
import ru.netology.authorization.exceptions.InvalidCredentials;
import ru.netology.authorization.exceptions.UnauthorizedUser;
import ru.netology.authorization.model.User;
import ru.netology.authorization.repository.UserRepository;

import java.util.List;
@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        String userName = user.getName();
        String password = user.getPassword();
        if (isEmpty(userName) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
