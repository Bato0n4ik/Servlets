package org.andreev.sockets.local;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Local {

    public static void main(String[] args) {
        /*Locale locale = new Locale("ru", "RU");
        System.out.println(Locale.getDefault());
        System.out.println(Locale.US);

        var translation = ResourceBundle.getBundle("translations" );
        System.out.println(translation.getString("page.login.password"));*/

        String page = "http://localhost:8080/login?lang=ru_RU?lang=en_US/";
        Pattern regex = Pattern.compile("\\?(lang=.+[?/])+$");
        Matcher matcher = regex.matcher(page);
        if(matcher.find()){
            String replaceSubString = page.substring(matcher.start(), matcher.end());
            page = page.replace(replaceSubString, "");
            System.out.println(page);
        }

    }
}
