package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Conexion {
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("database.properties")) {
            PROPS.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static final String URL = PROPS.getProperty("db.url");
    private static final String USER = PROPS.getProperty("db.user");
    private static final String PASSWORD = PROPS.getProperty("db.password");

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}