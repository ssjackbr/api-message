package com.api.message.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidateContactNumber {

    public static String formatContactNumber (String contactNumber) {

        String formattedNumber = contactNumber.replaceAll("\\D", "");

        if (formattedNumber.charAt(4) == '9') {
            formattedNumber = formattedNumber.substring(0, 4) + formattedNumber.substring(5);
        }
        return formattedNumber;
    }
}
