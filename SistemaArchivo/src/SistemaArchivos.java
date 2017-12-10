
import java.util.*;

/**
 *
 * @author Nicolas
 */
public class SistemaArchivos 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String comando;
        
        Disco disco = new Disco();
        FAT fat = new FAT();
        Memoria mem = new Memoria();
        
        while(sc.hasNext())
        {
            comando = sc.nextLine();
            if(comando.equals("Format"))
            {
                disco = new Disco();
            }
            else if(comando.equals("Create"))
            {
                System.out.println("Ingrese nombre del archivo");
                String nombre = sc.nextLine();
                while(nombre.length() > 8)
                {
                    System.out.println("Nombre muy largo, ingrese nombre de nuevo");
                    nombre = sc.nextLine();
                }
                System.out.println("Tamaño del archivo");
                String auxTamano = sc.nextLine();
                double tamano = Double.parseDouble(auxTamano);
                System.out.println("Contenido del archivo");
                String contenido = sc.nextLine();
                
                //Crear el archivo con los parametros entregados
                Archivo archivo = new Archivo(tamano, nombre, contenido);
                
                //Crear un FCB
                boolean[] arreglo = fat.getOcupados();
                int aux = 0;
                for (int i = 0; i < arreglo.length; i++) {
                    if(arreglo[i] == false)
                    {
                        aux = i;
                        break;
                    }
                }              
                FCB fcb = new FCB(archivo, aux);
                
                
                Sector sectorFcb = new Sector();
                sectorFcb.setFcb(fcb);
                
                Sector[] sectMemoria = mem.getSectores();
                
                int var = mem.getActual();
                if(var == 10)
                {
                    var = 0;
                }
                sectMemoria[var] = sectorFcb;
                mem.setActual(var++);
                
                int index = 0;
                boolean[] ocupados = disco.getOcupados();
                for (int i = 0; i < ocupados.length; i++) {
                    if(ocupados[i] == false)
                    {
                        index = i;
                    }
                }
                
                Sector[] sectores = disco.getSectores();
                sectores[index] = sectorFcb;
                disco.setSectores(sectores);
                
                int division = (int)Math.ceil(tamano/512);
                System.out.println("Bloques de FAT y disco: " + division + "------");
                
                for (int i = aux; i < division; i++) 
                {
                    int direccionDisco = new Random().nextInt(512);
                    while(ocupados[direccionDisco] == true)
                    {
                        direccionDisco = new Random().nextInt(512);
                    }
                    System.out.println("direccion de disco: " + direccionDisco);
                    arreglo[i] = true;
                    
                    Sector sectorArchivo = new Sector();
                    sectorArchivo.setArchivo(archivo);
                    sectores[direccionDisco] = sectorArchivo;
                    ocupados[direccionDisco] = true;
                            
                    
                    SectorFAT sfat = new SectorFAT(direccionDisco);
                    if(i+1 < division)
                    {
                        sfat.setPunteroBloqueFat(i+1);
                    }
                }
                fat.setOcupados(arreglo);
                disco.setOcupados(ocupados);
                disco.setSectores(sectores);
            }
                
        }
    }
}

