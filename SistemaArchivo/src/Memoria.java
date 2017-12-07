/**
 *
 * @author Nicolas
 */
public class Memoria 
{
    private Sector[] sectores;
    private boolean[] ocupados;
    private int tamano;

    public Memoria() 
    {
        this.tamano = 10;
        this.sectores = new Sector[tamano];
        this.ocupados = new boolean[tamano];
        for (int i = 0; i < tamano; i++) 
        {
            this.ocupados[i] = false;
        }
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
