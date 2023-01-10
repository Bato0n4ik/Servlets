package org.andreev.sockets.util;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {


    private final static String URL_KEY = "db.url";
    private final static String USER_KEY = "db.user";
    private final static String PASSWORD_KEY = "db.password";


    static{
        initDriver();
    }

    private ConnectionManager() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Connection get(){
        try{
            return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY),
                    PropertiesUtil.getProperty(USER_KEY),
                    PropertiesUtil.getProperty(PASSWORD_KEY));
        }
        catch(SQLException exc){
           exc.printStackTrace();
        }
        return null;
    }

    private static void initDriver() {
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException exc){
            exc.printStackTrace();
        }
    }
}
