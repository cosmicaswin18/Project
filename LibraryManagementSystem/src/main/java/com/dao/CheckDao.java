package com.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckDao {
	
	public static boolean phone(String s)
    {

        Pattern p = Pattern.compile("([+][0-9]{2,4})?([(][0-9]{3}[)])?([0-9]{2}[-])?[7-9][0-9]{9}");

        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
	
	public static boolean em(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
