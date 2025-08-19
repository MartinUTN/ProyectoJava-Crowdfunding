package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static final Properties PROPS = new Properties();
    private static String URL;
    private static String USER;
    private static String PASSWORD;


    static {
        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {

                System.err.println("Error: No se encontró el archivo 'database.properties'. Asegúrate de que esté en 'src/main/resources'.");
            } else {
                PROPS.load(input);
                URL = PROPS.getProperty("db.url");
                USER = PROPS.getProperty("db.user");
                PASSWORD = PROPS.getProperty("db.password");
                

                Class.forName("com.mysql.cj.jdbc.Driver");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            throw new ExceptionInInitializerError(e);
        }
    }


    public static Connection getConnection() throws SQLException {

        if (URL == null || USER == null || PASSWORD == null) {
            throw new SQLException("No se pudo establecer la conexión: la configuración de la base de datos no está completa.");
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
