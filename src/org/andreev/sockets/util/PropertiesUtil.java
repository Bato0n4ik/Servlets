package org.andreev.sockets.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties properties = new Properties();

    private PropertiesUtil(){}

    static{
        load();
    }

    private static void load() {
        try(var stream = PropertiesUtil.class.getClassLoader().getResourceAsStream("dbkeys.properties")){
            properties.load(stream);
        }
        catch(IOException exc){
            throw  new RuntimeException(exc);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
