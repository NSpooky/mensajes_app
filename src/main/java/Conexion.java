import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connetion() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "551410");
            if (connection != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
