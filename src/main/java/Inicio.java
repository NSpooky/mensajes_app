import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("===============================");
            System.out.println("Mini Red Social");
            System.out.println(" ");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    UsuarioService.crearUsuario();
                    break;
                case 2:
                    Usuario resultado = UsuarioService.iniciarSesion();
                    if (resultado.getId_usuario() > 0) {
                        menuSession(resultado);
                    }
                    break;
                default:
                    break;
            }
        }while (opcion != 3);
    }

    public static void menuSession(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("---------------");
            System.out.println("::Red Social::");
            System.out.println("::Hola " + usuario.getNombre_completo());
            System.out.println("1. Escribir un mensaje");
            System.out.println("2. Leer mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Editar perfil");
            System.out.println("6. Ver usuarios");
            System.out.println("7. Cerrar sesion");

            //Leer opcion del usuario
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje(usuario);
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje(usuario);
                    break;
                case 5:
                    UsuarioService.editarUsuario(usuario);
                    break;
                case 6:
                    UsuarioService.listarUsuario();
                    break;
                default:
                    break;
            }
        }while (opcion != 7);
    }
}
