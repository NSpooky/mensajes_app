import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;


public class UsuarioService {
    public static void crearUsuario(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Indica tu nombre completo: ");
        String nombre_completo = sc.nextLine();
        System.out.println("Indica tu correo: ");
        String correo = sc.nextLine();
        System.out.println("Indica tu clave: ");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);

        Usuario registro = new Usuario(0, correo, clave, nombre_completo);
        UsuarioDAO.crearUsuarioDB(registro);
    }

    public static void listarUsuario(){
        UsuarioDAO.leerUsuarioDB();
    }

    public static void editarUsuario(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica tu nombre completo: ");
        String nombre_completo = sc.nextLine();
        System.out.println("Indica tu correo: ");
        String correo = sc.nextLine();
        System.out.println("Indica tu clave: ");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);

        Usuario registro = new Usuario(usuario.getId_usuario(), correo, clave, nombre_completo);
        UsuarioDAO.editarUsuarioDB(registro);
    }

    public static String cifrarMD5(String clave){
        String md5Hex = DigestUtils.md5Hex(clave);
        return md5Hex;
    }

    public static Usuario iniciarSesion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica tu correo: ");
        String correo = sc.nextLine();
        System.out.println("Indica tu clave: ");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);

        Usuario login = new Usuario(correo, clave);
        Usuario resultado = UsuarioDAO.iniciarSesionDB(login);
        return resultado;
    }
}
