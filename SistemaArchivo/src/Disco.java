/**
 *
 * @author Nicolas
 */
public class Disco 
{
    private Sector[] sectores;
    private int tamano;
    private int disponibles;

    public Disco() 
    {
        this.tamano = 512;
        this.sectores = new Sector[this.tamano];
        this.disponibles = 512;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
    
    
    
    
    
}
