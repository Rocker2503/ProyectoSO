
import java.util.Scanner;

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
        Disco disco;
        FAT fat;
        while(sc.hasNext())
        {
            comando = sc.nextLine();
            if(comando.equals("Format"))
            {
                disco = new Disco();
                fat = new FAT();
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
                int tamano = Integer.parseInt(auxTamano);
                String contenido = sc.nextLine();
                
                //Crear el archivo con los parametros entregados
                Archivo archivo = new Archivo(tamano, nombre, contenido);
                
                //Crear un FCB
                FCB fcb = new FCB(archivo, 0);
            }
        }
    }
}
