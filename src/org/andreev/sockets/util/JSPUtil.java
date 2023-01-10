package org.andreev.sockets.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JSPUtil {
    private final static String JSP_FILES_PATH = "WEB-INF/jsp/%s.jsp";

    public static String getJspFilesPath(String fileName){
        return String.format(JSP_FILES_PATH, fileName);
    }
}
