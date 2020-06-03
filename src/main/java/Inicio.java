import java.sql.Connection;
import java.sql.SQLException;

public class Inicio {
    public static void main(String[] args) {
        Conexion c = new Conexion();
        try {
            Connection cnt = c.get_connetion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
