/**
 *
 * @author Nicolas
 */
public class FAT 
{    
    private SectorFAT[] bloques;
    private boolean[] ocupados;

    public FAT() 
    {

        this.ocupados = new boolean[512];        
        for (int i = 0; i < 512; i++) 
        {
            this.ocupados[i] = false;
        }
        
        this.bloques = new SectorFAT[512];
        /*for (int i = 0; i < 512; i++) {
            SectorFAT bloque = bloques[i];
            
        }*/
        
    }

    public boolean[] getOcupados() {
        return ocupados;
    }

    public void setOcupados(boolean[] ocupados) {
        this.ocupados = ocupados;
    }

    public SectorFAT[] getBloques() {
        return bloques;
    }

    public void setBloques(SectorFAT[] bloques) {
        this.bloques = bloques;
    }
    
}
