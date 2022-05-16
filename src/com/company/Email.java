package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String address;

    public Email(String address) {
        set(address);
    }

    private void set(String address) {
        if (!isEmailValid(address)) {
            do {
                System.out.println("Ошибка ввода email, введите телефон еще раз: ");
                address = Main.in.nextLine();
            } while (isEmailValid(address));
        }
        this.address = address;
    }

    private boolean isEmailValid(String address) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }
}