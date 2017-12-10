/**
 *
 * @author Nicolas
 */
public class Memoria 
{
    private Sector[] sectores;
    private boolean[] ocupados;
    private int tamano;
    private int actual;

    public Memoria() 
    {
        this.tamano = 10;
        this.actual = 0;
        this.sectores = new Sector[tamano];
        this.ocupados = new boolean[tamano];
        for (int i = 0; i < tamano; i++) 
        {
            this.ocupados[i] = false;
        }

    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
    public Sector[] getSectores() {
        return sectores;
    }

    public void setSectores(Sector[] sectores) {
        this.sectores = sectores;
    }

    public boolean[] getOcupados() {
        return ocupados;
    }

    public void setOcupados(boolean[] ocupados) {
        this.ocupados = ocupados;
    }

    public int getTamano() {
        return tamano;
    }
    
}
