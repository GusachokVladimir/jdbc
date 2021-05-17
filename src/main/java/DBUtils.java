import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static String dbURL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private static String dbUsername = "sa";
    private static String dbPassword = "";

    public static Connection getConnection(){
/*
        String dbURL = null;
        String dbUsername = "sa";
        String dbPassword = "";

        FileInputStream fis ;
        Properties properties = new Properties();

        try {
             fis = new FileInputStream("sqc/main/resources/config.properties");
             properties.load(fis);

             dbURL = properties.getProperty("db.host");

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }

*/
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return connection;
    }
}
