

/**
 *
 * @author Nicolas
 */
public class SectorFAT {
    private int indiceDisco;
    private int punteroBloqueFat;

    public SectorFAT(int indiceDisco) {
        this.indiceDisco = indiceDisco;
        this.punteroBloqueFat = -1;
    }

    public int getIndiceDisco() {
        return indiceDisco;
    }

    public void setIndiceDisco(int indiceDisco) {
        this.indiceDisco = indiceDisco;
    }

    public int getPunteroBloqueFat() {
        return punteroBloqueFat;
    }

    public void setPunteroBloqueFat(int punteroBloqueFat) {
        this.punteroBloqueFat = punteroBloqueFat;
    }
    
}
