package br.com.systemmembercontrol.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailValidator {

    public static boolean isValidEmail(String email) {
       return org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email);

    }

}
