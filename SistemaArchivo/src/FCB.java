/**
 *
 * @author Nicolas
 */
public class FCB 
{
    private Archivo archivo;
    private int indice;

    public FCB(Archivo archivo, int indice) 
    {
        this.archivo = archivo;
        this.indice = indice;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    
}
