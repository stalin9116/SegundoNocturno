
package prysegundoa.Objetos;


public class ComboboxItems {
    
    private String codigo;
    private String item;

    //Constructor
    public ComboboxItems(String codigo, String item) {
        this.codigo = codigo;
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return this.item= item;
    }
    
    
    
}
