public class Usuario {
    int id_usuario;
    String correo;
    String clave;
    String nombre_completo;

    public Usuario() {
    }

    //Para borrar usuario
    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    //Para iniciar sesion
    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    //Para traer datos de inicio de sesion
    public Usuario(int id_usuario, String correo, String nombre_completo) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.nombre_completo = nombre_completo;
    }

    //Para crear, editar usuario
    public Usuario(int id_usuario, String correo, String clave, String nombre_completo) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.clave = clave;
        this.nombre_completo = nombre_completo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
}
