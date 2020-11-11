package co.unicauca.domicilios.infra;

/**
 * Parametro.
 * Lo usa la clase Protocol
 * @author Libardo, Julio
 */
public class Parameter {

    private String name;
    private String value;
    private byte[] imagen;

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Parameter() {

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

}
