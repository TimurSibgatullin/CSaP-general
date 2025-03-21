package itis.grp403.TimurSibgatullin;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(isDigit('5')); // true
        System.out.println(isDigit('a')); // false
    }

    static boolean isDigit(char c) {
        return c >= 'A' && c <= 'a';

    }
}