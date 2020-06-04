import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public static void crearUsuarioDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connetion()) {
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO usuarios(correo, clave, nombre_completo) VALUES (?, ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombre_completo());
                ps.executeUpdate();

                System.out.println("Usuario creado, ahora puedes iniciar sesion.");
            }catch (SQLException e) {
                System.out.println(e);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerUsuarioDB(){
        Conexion db_connet = new Conexion();
        try(Connection conexion = db_connet.get_connetion()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM usuarios";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("--------");
                    System.out.println("ID: " + rs.getString("id"));
                    System.out.println("Correo: " + rs.getString("correo"));
                    System.out.println("Nombre: " + rs.getString("nombre_completo"));
                }
            }catch (SQLException e) {
                System.out.println(e);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void editarUsuarioDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connetion()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE usuarios SET correo = ?, clave = ?, nombre_completo = ? WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombre_completo());
                ps.setInt(4, usuario.getId_usuario());
                ps.executeUpdate();
                System.out.println("Usuario actualizado");
            }catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo actualizar el usuario");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static Usuario iniciarSesionDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM usuarios WHERE correo = ? AND clave = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                rs = ps.executeQuery();
                Usuario login = new Usuario();
                if (rs.next()) {
                    System.out.println("Login correcto!!!!");
                    login.setId_usuario(rs.getInt("id"));
                    login.setCorreo(rs.getString("correo"));
                    login.setNombre_completo(rs.getString("nombre_completo"));
                }else {
                    System.out.println("Login incorrecto");
                }
                return login;
            }catch (SQLException e) {
                System.out.println(e);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
