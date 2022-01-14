package prysegundoa.Objetos;

public class Usuario {

    //atributos
    private int codigo;
    private String correo;
    private String clave;
    private String nombre;
    private String apellido;
    private Rol rol;

    public Usuario() {

    }

    public int obtenerCodigo() {
        return codigo;
    }

    public void modificarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void modificarCorreo(String correo) {
        this.correo = correo;
    }

    public String obtenerClave() {
        return clave;
    }

    public void modificarClave(String clave) {
        this.clave = clave;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void modificarApellido(String apellido) {
        this.apellido = apellido;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "" + nombre + " " + apellido + "\n" + this.getRol().getDescripcion();
    }

}
