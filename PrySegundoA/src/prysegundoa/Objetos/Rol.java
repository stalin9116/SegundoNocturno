
package prysegundoa.Objetos;


public class Rol {
    
    private int codigoRol;
    private String descripcion;
    private String estado;

    public Rol() {
        
    }

    public Rol(int codigo, String descripcion) {
        this.codigoRol = codigo;
        this.descripcion= descripcion;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
