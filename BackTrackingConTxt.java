package FADA;
import java.util.Arrays;


import java.io.FileReader;
import java.io.IOException;
/**
 * @author luisalvaranleav
 */
public class BackTrackingConTxt {
    int cantidadSelecciones;  // 
    int villa[];  // Arreglo utilizado para las posibles villas a construir 
    
    // Constructor
    BackTrackingConTxt(int cs){
        cantidadSelecciones = cs;
    }
    
    // Este metodo comprueba si es seguro asignarle la villa actual a la seleccion
    boolean esSeguro(int v, int M[][], int villa[], int c) { 
        for (int i = 0; i < cantidadSelecciones; i++) 
            if (M[v][i] == 1 && c == villa[i]){ 
                return false; 
            }
        return true; 
    } 
  
    // Este metodo retorna true si a todos las selecciones se le asigna una villa
    // retorna false si no se le puede asignar la villa a una seleccion
    boolean asignaVillaAuxiliar(int M[][], int villa[], int v) {   
        int cs = cantidadSelecciones;
        
        if (v == cs){ 
            return true; 
        }
        for (int i = 1; i <= cs; i++){ // En este for i hace rerferencia a la villa 
            // Comprueba si la asgnacion de la villa es correcta llamando al metodo es esSeguro(...);
            if (esSeguro(v, M, villa, i)){ // si es seguro entonces se asgina o se crea la villa  
                villa[v] = i; 
  
                // repite el proceso (recursion) hasta que v = cs, es decir todas 
                // las selecciones tienen asignada una villa para su alojamiento*/
                if (asignaVillaAuxiliar(M, villa, v + 1)){ 
                    return true; 
                }
                // Si asignar una villa a determinada seleccion no conduce a la solucion
                // entonces se elimina esa opcion (no se le asigna) y hace el ciclo
                villa[v] = 0; 
            } 
        } 
        return false; 
    } 
  
    boolean asignaVilla(int M[][]){ 
        int cs = cantidadSelecciones;
        int [][] S = new int[cs][cs];  /* Matriz solucion:  S[i,j]= 1 si en la
                                        * villa i se aloja la selección j, en otro caso S[i,j] = 0. */
        
        // se inicializa todos los valores del arreglo villa en 0 
        villa = new int[cs]; 
        Arrays.fill(villa, 0);
  
        if (!asignaVillaAuxiliar(M, villa, 0)){
            return false; 
        } 
  
        System.out.println("\n\n////////////VILLAS//////////");
        /**** Imprime Solucion ****/
        int c = 0; // lleva conteo de las villas construidas
        for (int i = 0; i < cantidadSelecciones; i++){ 
            S[villa[i]-1] [i] = 1; //coloca la seleccion en la villa correspondiente
            if(villa[i] >= c) {
                c = villa[i]; // Valor maximo de villas construidas = n filas
            } 
        }
        for(int i=0; i < c; i++){ // Imprime S[i,j]
            System.out.println();
            for(int j=0; j < cantidadSelecciones; j++){
                System.out.print(S[i][j]+" ");
            }
        }
        System.out.println();
        return true; 
    } 
  
    // Main
    public static void main(String args[]) {
        final String nomFichero="C:\\Users\\miime_000\\Documents\\NetBeansProjects\\FADA\\src\\fada\\M.txt";
        try(FileReader fr=new FileReader (nomFichero)){
                int valor=fr.read();
                String tamano="";
                /*Se lee el primer valor, para saber el tamaño de los arreglos m y s respectivamente*/
                if(valor!=48 && valor!=49){
                    tamano = Character.toString((char)valor);
                }
                int size=Integer.parseInt(tamano);
		int[][] m = new int[size][size];
		int[][] s = new int[size][size];
                /*Continuación de lectura*/
                /*Saltos para evitar leer espacios en blanco*/
                for(int i=0;i<3;i++){
                    valor=fr.read();
                }
                int x=0,z=0;
                /*Mientras el archivo contenga valores, se leerá cada posición*/
                while(valor!=-1){
                        /*en ASCII 32 es el espacio, así que no es necesario tenerlo en cuenta*/
                        if(valor!=32){
                            if(z<size){
                                /*como los valores están en ASCII (char) los convertimos a enteros*/
                                m[x][z]=Character.getNumericValue((char)valor);
                                z++;
                                /*se continúa con la lectura de archivo*/
                                valor=fr.read();
                            }
                            /*En caso de haber llegado a la posición horizontal final*/
                            else{
                                z=0;
                                x++;
                            }
                        }
                    /*Continuamos con la lectura de los datos que siguen en el archivo*/
                    valor=fr.read(); 
                }
                System.out.print("////////////MATRIZ M//////////\n");
                /*impresión de m*/
                for (int t=0; t<size;t++){
                    System.out.println("");
                    for(int n=0; n<size; n++){
                        System.out.print(m[t][n]+" ");
                    }
                }
        BackTrackingConTxt villas = new BackTrackingConTxt(size); 
        villas.asignaVilla(m);
        }catch(IOException e){
            System.out.println("Problemas con el E/S "+e);
        }
    }  
}
