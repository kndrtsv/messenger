package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private String phone;

    public Phone(String phone) {
        set(phone);
    }

    public void set(String phone) {
        if (!isPhoneValid(phone)) {
            do {
                System.out.println("Ошибка ввода номера телефона, введите телефон еще раз: ");
                phone = Main.in.nextLine();
            } while (!isPhoneValid(phone));
        }
        this.phone = phone;
    }

    public boolean isPhoneValid(String phone) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}