package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.access_rights.Authorities;
import ru.netology.authorization.exceptions.InvalidPassword;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, List<Authorities>> userAuthorities;
    private final Map<String, String> passwords;

    public UserRepository() {
        passwords = new ConcurrentHashMap<>();
        passwords.put("Max", "M123");
        passwords.put("Neil", "321N");
        passwords.put("John", "J111J");

        userAuthorities = new ConcurrentHashMap<>();
        userAuthorities.put("Max", new ArrayList<>(Arrays.asList(Authorities.WRITE, Authorities.DELETE)));
        userAuthorities.put("Neil", new ArrayList<>(Collections.singletonList(Authorities.READ)));
        userAuthorities.put("John", new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!userAuthorities.containsKey(user) || passwords.get(user) == null) {
            return null;
        }
        if (checkPassword(user, password)) {
            return userAuthorities.get(user);
        } else {
            throw new InvalidPassword("Invalid password!");
        }
    }

    private boolean checkPassword(String user, String password) {
        return passwords.get(user).equals(password);
    }
}
