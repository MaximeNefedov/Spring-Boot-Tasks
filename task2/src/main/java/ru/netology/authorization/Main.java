package ru.netology.authorization;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final String x1 = "a-+s*/,d.";
        final String x = "Niggaflip";
//        System.out.println(x.matches("[^.,\\-+/*]"));
//        System.out.println(x.matches("^([^a-zA-Z]*([a-zA-Z]+)[^a-zA-Z]*)+$"));
        System.out.println(x.matches("^([^0-9]*([0-9]+)[^0-9]*)+$"));
    }
}

