package org.example.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtility {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX) ;

    public static Boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() ;
    }

}
