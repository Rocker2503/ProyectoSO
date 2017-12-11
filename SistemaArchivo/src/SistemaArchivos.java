
import java.util.*;

/**
 *
 * @author Nicolas
 */
public class SistemaArchivos 
{
    public static void main(String[] args) 
    {
        Menu menu = new Menu();
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        String comando;
        
        Disco disco = new Disco();
        FAT fat = new FAT();
        Memoria mem = new Memoria();
        
        while(opcion != 0)
        {
            menu.printMenuPrincipal();
            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion)
            {
                case 0:
                    System.out.println("");
                    System.out.println("Buen dia le desea Nicolas y Juan");
                    System.exit(0);
                    break;
                    
                case 1: //Format
                    disco = new Disco();
                    break;
                    
                case 2: //Create
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
                    int aux = fatLibre(fat);
                            
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

                    int index = discoLibre(disco);
                    
                
                    Sector[] sectores = disco.getSectores();
                    sectores[index] = sectorFcb;
                    disco.setSectores(sectores);

                    int division = (int)Math.ceil(tamano/512);
                    System.out.println("Bloques de FAT y disco: " + division + "------");
                    
                    boolean[] ocupados = disco.getOcupados(); 
                    boolean[] arreglo = fat.getOcupados();
                
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
                    break;
                
                case 3: //Remove    
                    System.out.print("Ingrese el nombre del archivo a eliminar: ");
                    nombre = sc.nextLine();
                    
                    System.out.println(""+ fat.getBloques());
                    //liberar archivo contenido en memoria
                    liberarArchivo(mem.getSectores(), mem.getTamano(), nombre, fat);
                    
                    //liberar archivo contenido en disco
                    liberarArchivo(disco.getSectores(), disco.getTamano(), nombre, fat);
                    break;
                    
                case 4: //ReadAt
                    break;
                    
                case 5: //WriteAt
                    break;
                    
                case 6: //PrintFile
                    System.out.print("Ingrese el nombre del archivo a imprimir: ");
                    nombre = sc.nextLine();
                    
                    String res;
                    //muestra el archivo cargado desde memoria
                    res = mostrarContenido(nombre, mem.getSectores(), mem.getTamano(), fat);
                    
                    //si no lo encuentra en memoria lo busca en disco
                    if(res == null)
                        mostrarContenido(nombre, disco.getSectores(), disco.getTamano(), fat);
                    break;
                    
                case 7: //List
                    break;
            }
        }
    }

    //Obtener un indice desocupado en la fat
    public static int fatLibre(FAT fat) 
    {
        boolean[] arreglo = fat.getOcupados();
        int aux = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == false)
            {
                aux = i;
                break;
            }
        }
        return aux;
    }
    //Obtener un indice desocupado en el disco
    public static int discoLibre(Disco disco) 
    {
        int index = 0;
        boolean[] ocupados = disco.getOcupados();     
        for (int i = 0; i < ocupados.length; i++) 
        {
            if(ocupados[i] == false)
            {
                index = i;
            }
        }
        return index;
    }

    public static void liberarArchivo(Sector[] sectores, int tamano, String nombre, FAT fat) 
    {
        for (int i = 0; i < tamano; i++) 
        {
            if(sectores[i] != null)
            {
                Sector s = sectores[i];
                FCB fcb = s.getFcb();
                if(fcb != null)
                {
                    Archivo archi = fcb.getArchivo();
                    if(nombre.equals(archi.getNombre()))
                    {
                        int direccionFat = fcb.getIndice();
                        SectorFAT[] sectoresF = fat.getBloques();
                        boolean[] ocupados = fat.getOcupados();

                        System.out.println("sectoresFL: " + sectoresF.length);
                        for (int j = direccionFat; j < sectoresF.length; j++)
                        {
                            if(sectoresF[i]!= null)
                            {
                                sectoresF[i].setIndiceDisco(0);
                                ocupados[i] = false;
                                if(sectoresF[i].getPunteroBloqueFat() == -1)
                                {
                                    break;
                                }
                                else if(sectoresF[i].getPunteroBloqueFat() != -1)
                                {
                                    sectoresF[i].setPunteroBloqueFat(-1);
                                }
                            }
                        }
                        sectores[i] = new Sector();
                    }
                }
            }
        }
    }

    public static String mostrarContenido(String nombre, Sector[] sectores, int tamano, FAT fat) 
    {
        for (int i = 0; i < tamano; i++) 
        {
            if(sectores[i] != null)
            {
                Sector s = sectores[i];
                FCB fcb = s.getFcb();
                if(fcb != null)
                {
                    Archivo archi = fcb.getArchivo();
                    if(nombre.equals(archi.getNombre()))
                    {
                        return archi.getContenido();
                    }
                }

            }
        }
        return null;
    }
}

