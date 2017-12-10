/**
 *
 * @author Nicolas
 */
public class FAT 
{
    private int[] direcciones;
    private Sector[] sectores;
    private boolean[] ocupados;

    public FAT() 
    {
        this.direcciones = new int[512];
        this.sectores = new Sector[512];
        this.ocupados = new boolean[512];
        
        for (int i = 0; i < 512; i++) 
        {
            this.direcciones[i] = 0;
            this.ocupados[i] = false;
        }
        
    }

    public int[] getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(int[] direcciones) {
        this.direcciones = direcciones;
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
    
    
}
