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
        final String nomFichero="C:\\Users\\miime_000\\Documents\\NetBeansProjects\\FADA\\src\\fada\\M.txt";
        try(FileReader fr=new FileReader (nomFichero)){
                int valor=fr.read();
                String tamano="";
                if(valor!=48 && valor!=49){
                    tamano = Character.toString((char)valor);
                }
                int size=Integer.parseInt(tamano);
		int[][] m = new int[size][size];
		int[][] s = new int[size][size];
                char[][] matriz= new char[size][size];
                System.out.print("//////////////MATRIZ INGRESADA//////////////\n");
                valor=fr.read();
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        while(valor!=-1){
                            //System.out.print((char)valor);
                            matriz[i][j]=(char)valor;
                            valor=fr.read();
                        }
                    }
                }
            System.out.print("\n\n/////////MATRIZ M///////////////\n");
            for (int i=0; i<size;i++){
                System.out.println("");
                for(int j=0; j<size; j++){
                    System.out.print(matriz[i][j]);
                }
            }
            //System.out.print(matriz+"\n");
        }catch(IOException e){
            System.out.println("Problemas con el E/S "+e);
        }
    }
    
}

        
