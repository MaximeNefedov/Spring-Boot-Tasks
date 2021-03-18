package ru.netology.authorization.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
public class User {
    @Pattern(regexp = "[A-Z].+", message = "Имя должно начинаться с большой буквы и имя не может быть пустым")
    @Pattern(regexp = "[^.,\\-+/*]+", message = "В имени пользователя не допускается использовать символы . , \\ - + / *")
    private String name;
    @Size(min = 3, max = 10)
    @Pattern(regexp = "^([^0-9]*([0-9]+)[^0-9]*)+$", message = "Пароль должен содержать как минимум одну цифру")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name;
    }
}
