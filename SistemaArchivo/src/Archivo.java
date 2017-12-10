/**
 *
 * @author Nicolas
 */
public class Archivo 
{
    private double tamano;
    private String nombre;
    private String contenido;
    
    public Archivo(double tamano, String nombre, String contenido)
    {
        this.tamano = tamano;
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public double getTamano() {
        return tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}
