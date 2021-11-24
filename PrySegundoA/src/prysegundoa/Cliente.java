
package prysegundoa;


public class Cliente {
    
    /* Atributos */
    
    private String identificacion;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String telefono;

    //Constructor
    
    public Cliente() {
        
    }
    
    public Cliente(String telefono) {
        this.telefono=telefono;
    }
    
    
    //Metodos publicos get y set de todos los atributos

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void modificarTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String obtenerTelefono(){
        return telefono;
    }
    
    
}
