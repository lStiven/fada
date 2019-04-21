/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fada;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author miime_000
 */
public class Texto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic here
        /*la variable nomFichero tendrá la ruta donde se encuentre el txt con el arreglo,
        para que se lea correctamente debe estar como en los ejemplos:
        5
        0 1 0 1 0
        1 0 1 0 1
        0 1 0 1 0
        1 0 1 0 1
        0 1 0 1 0*/
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
                int x=0,y=0;
                /*Mientras el archivo contenga valores, se leerá cada posición*/
                while(valor!=-1){
                        /*en ASCII 32 es el espacio, así que no es necesario tenerlo en cuenta*/
                        if(valor!=32){
                            if(y<size){
                                /*como los valores están en ASCII (char) los convertimos a enteros*/
                                m[x][y]=Character.getNumericValue((char)valor);
                                y++;
                                /*se continúa con la lectura de archivo*/
                                valor=fr.read();
                            }
                            /*En caso de haber llegado a la posición horizontal final*/
                            else{
                                y=0;
                                x++;
                            }
                        }
                    /*Continuamos con la lectura de los datos que siguen en el archivo*/
                    valor=fr.read(); 
                }
            System.out.print("/////////MATRIZ m///////////////\n");
            /*impresión de m*/
            for (int i=0; i<size;i++){
                System.out.println("");
                for(int j=0; j<size; j++){
                    System.out.print(m[i][j]+" ");
                }
            }
        }catch(IOException e){
            System.out.println("Problemas con el E/S "+e);
        }
    }  
}
