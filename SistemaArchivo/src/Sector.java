/**
 *
 * @author Nicolas
 */
public class Sector 
{
    private int tamano;
    private Archivo archivo;
    private FCB fcb;


    public Sector() {
        this.tamano = 512;
        this.archivo = null;
        this.fcb = null;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    public FCB getFcb() {
        return fcb;
    }

    public void setFcb(FCB fcb) {
        this.fcb = fcb;
    }
    
}
