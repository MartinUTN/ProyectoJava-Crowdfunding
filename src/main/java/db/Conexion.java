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
            if (input == null) {
                System.err.println("Error: El archivo database.properties no se encontró en el classpath.");
                throw new IOException("El archivo database.properties no se puede cargar.");
            }
            PROPS.load(input);
            // Carga el driver de JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("No se pudo inicializar la conexión con la base de datos.");
        }
    }

    private static final String URL = PROPS.getProperty("db.url");
    private static final String USER = PROPS.getProperty("db.user");
    private static final String PASSWORD = PROPS.getProperty("db.password");

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
