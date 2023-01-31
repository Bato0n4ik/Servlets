package org.andreev.sockets.local;

import java.util.Locale;
import java.util.ResourceBundle;

public class Local {

    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        System.out.println(Locale.getDefault());
        System.out.println(Locale.US);

        var translation = ResourceBundle.getBundle("translations" );
        System.out.println(translation.getString( "page.name.password"));
    }
}
