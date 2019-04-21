/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FADA;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GrafoConTxt {
    private int V; // Número de vertices (numero de selecciones) 
	private LinkedList<Integer> ady[]; // Lista de adyacencia
	private static Scanner sc;

	// Constructor 
	GrafoConTxt(int v) { 
		V = v; 
		ady = new LinkedList[v]; // Inicializamos la lista enlazada (lista de adyancencia)
		for (int i=0; i<v; ++i) 
			ady[i] = new LinkedList(); 
	
	}
	
	/* Este método recibe un grafo no dirigido y la matriz de selecciones (matriz de adyacencia)
	 * para asociar los vertices del grafo (crearArista)
	 */
	void matrizAdyacente(GrafoConTxt g,int M[][]){
		int contador = 0;
	    for(int i=0; i<M.length; i++){
	        for(int j=0; j<M.length; j++){
		        if (M[i][j] == 1){
			        g.crearArista(i, j);
			        //System.out.print(("("+ i + "," + j + ")")+",");
		        }
	    	}        
	    }
     	g.construirVilla();
	}
 
	// Metodo que añade las aristas en el grafo (lista de adyacencia) dado los vertices adyacentes
	void crearArista(int v,int w) { 	
		// Grafo no dirigido, por eso se unen con aristas en ambos sentidos entre par de vertices
		ady[v].add(w); 
		ady[w].add(v); 
	} 

	/* Asigna las villas indexadas desde 0 a todos los vertice e imprime una
	 * matriz que contiene las villas asignadas a cada pais, donde n son las 
	 * filas (villas a construir) y m las columnas (selecciones). */
	void construirVilla(){ 
		int [][] S = new int[V][V]; /*  * Matriz solucion:  S[i,j]= 1 si en la
						* villa i se aloja la selección j, en
						* otro caso S[i,j] = 0.
						*/
		int resultado[] = new int[V];  // Arreglo utilizado para el numero de villas

		/* Se inicializa todos los vertices sin signo para indicar que aun 
		 * ninguna seleccion tiene asociada una villa para alojarse */
		Arrays.fill(resultado, -1); 

		// Se asigna directamente la primer villa al primer pais ya que no existe problema
		resultado[0] = 0; 

		/* Arreglo Booleano utilizado para almacenar las villas disponibles. 
		 * false: villa ya asignada a un vertice adyacente (seleccion)
		 * true: villa disponible para asignar a un vertice adyacente (seleccion)
		 */
		boolean villaDisponible[] = new boolean[V]; 
		Arrays.fill(villaDisponible, true); 
		
		// Construye o asigna villas a las selecciones restantes que aun no tienen ninguna villa asignada
		for (int u = 1; u < V; u++){ // itera sobre todos los vertices adyacentes 
			Iterator<Integer> it = ady[u].iterator() ; 
			while (it.hasNext()) { 
				int i = it.next(); 
				if (resultado[i] != -1){
					villaDisponible[resultado[i]] = false; 
				/* Si una determinada seleccion ya tiene una villa asignada 
				* la pone como no disponible (false) para sus selecciones adyacentes 
				* (selecciones que no tienen relaciones diplomaticas) 
				* para no asingarle la misma villa*/
				}
			} 

			// Encuentra la primera villa disponible (true)
			int villa; 
			for (villa = 0; villa < V; villa++){ 
				if (villaDisponible[villa]){ 
					break; 
				}
			} 
			resultado[u] = villa; // Asigna la villa 

			// Se vuelven a colocar todos los valores en true para la proxima iteracion
			Arrays.fill(villaDisponible, true); 
		} 

		// 
		int c = 0; // lleva conteo de la cantidad de Villas
		for (int u = 0; u < V; u++) {
			S[resultado[u]][u] = 1; // resultado[u]: fila n,   u: columna m
			if(resultado[u] >= c) {
				c = resultado[u]; // Valor maximo de villas construidas = n filas
			}
		}

                System.out.println("\n\n////////////VILLAS//////////");
		// Imprime la matriz solucion S[i,j]
		for(int i=0; i <= c; i++) {
			System.out.println();
			for (int j=0; j<S.length; j++) {
				System.out.print(S[i][j] + " ");
			}
		}
		
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
		GrafoConTxt g1 = new GrafoConTxt(size); 
		
		// Se llama el metodo pasando el grafo y la matriz M
		g1.matrizAdyacente(g1,m);
                }catch(IOException e){
                    System.out.println("Problemas con el E/S "+e);
                }
    }
    
}
