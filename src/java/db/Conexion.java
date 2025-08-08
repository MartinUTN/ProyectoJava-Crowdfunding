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
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("No se pudo inicializar la conexión con la base de datos debido a un error de I/O.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("No se pudo inicializar la conexión con la base de datos. Asegúrate de que el driver de MySQL está en tu classpath.");
        }
    }

    private static final String URL = PROPS.getProperty("db.url");
    private static final String USER = PROPS.getProperty("db.user");
    private static final String PASSWORD = PROPS.getProperty("db.password");

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

