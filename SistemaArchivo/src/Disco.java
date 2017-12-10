/**
 *
 * @author Nicolas
 */
public class Disco 
{
    private Sector[] sectores;
    private boolean[] ocupados;
    private int tamano;
    private int disponibles;

    public Disco() 
    {
        this.tamano = 512;
        this.sectores = new Sector[this.tamano];
        this.ocupados = new boolean[this.tamano];
        for (int i = 0; i < tamano; i++) {
            this.ocupados[i] = false;
        }
        this.disponibles = 512;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public boolean[] getOcupados() {
        return ocupados;
    }

    public void setOcupados(boolean[] ocupados) {
        this.ocupados = ocupados;
    }

    public Sector[] getSectores() {
        return sectores;
    }

    public void setSectores(Sector[] sectores) {
        this.sectores = sectores;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
}
