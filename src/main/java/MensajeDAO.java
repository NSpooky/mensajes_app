import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {
    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (id_usuario, mensaje, fecha) VALUES (?, ?, CURRENT_TIMESTAMP)";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getId_usuario());
                ps.setString(2, mensaje.getMensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado correctamente");
            }catch (SQLException e) {
                System.out.println(e);
            }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection conexion = db_connect.get_connetion()) {
            String query = "SELECT m.id, m.mensaje, m.fecha, u.nombre_completo FROM mensajes m JOIN usuarios u ON m.id = u.id";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha"));
                System.out.println("Autor: " + rs.getString("nombre_completo"));
                System.out.println("-----");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connetion()) {
            PreparedStatement ps = null;
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado con exito.");
            }catch (SQLException e) {
                System.out.println(e);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connetion()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id = ? AND id_usuario = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, mensaje.id_mensaje);
                ps.setInt(2, mensaje.id_usuario);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado.");
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
