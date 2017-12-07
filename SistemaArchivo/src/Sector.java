/**
 *
 * @author Nicolas
 */
public class Sector 
{
    private int tamano;
    private FCB fcb;

    public Sector(int tamano, FCB fcb) {
        this.tamano = tamano;
        this.fcb = fcb;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public FCB getFcb() {
        return fcb;
    }

    public void setFcb(FCB fcb) {
        this.fcb = fcb;
    }
    
}
