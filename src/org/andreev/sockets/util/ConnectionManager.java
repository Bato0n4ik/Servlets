package org.andreev.sockets.util;

import org.postgresql.Driver;
import org.postgresql.core.TypeInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {


    private final static String URL_KEY = "db.url";
    private final static String USER_KEY = "db.user";
    private final static String PASSWORD_KEY = "db.password";


    static{
        initDriver();
    }


    private ConnectionManager(){}

    public static Connection get(){
        try{
            return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY),
                    PropertiesUtil.getProperty(USER_KEY),
                    PropertiesUtil.getProperty(PASSWORD_KEY));
        }
        catch(Exception exc){
            exc.printStackTrace();
            throw new RuntimeException(exc);
        }
    }

    private static void initDriver() {
        try{
            //Class<Driver> driver = Driver.class;
            //DriverManager.registerDriver(new org.postgresql.Driver());
            //DriverManagerDataSource ds = new DriverManagerDataSource();
            //ds.set
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException exc){
            throw new RuntimeException(exc);
        }
    }
}
