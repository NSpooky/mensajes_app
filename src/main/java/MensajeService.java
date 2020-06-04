import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje(Usuario usuario) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre:");
        String nombre = sc.nextLine();

        Mensaje el_mensaje = new Mensaje(mensaje, usuario.getId_usuario());

        MensajeDAO.crearMensajeDB(el_mensaje);
    }

    public static void listarMensajes() {
        MensajeDAO.leerMensajeDB();
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("Indica el id del mensaje a editar: ");
        int id_mensaje = sc.nextInt();

        Mensaje actualizacion = new Mensaje();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajeDAO.actualizarMensajeDB(actualizacion);
    }

    public static void borrarMensaje(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje a borrar: ");
        int id_mensaje = sc.nextInt();
        Mensaje el_mensaje = new Mensaje(id_mensaje, usuario.getId_usuario());
        MensajeDAO.borrarMensajeDB(el_mensaje);
    }
}
