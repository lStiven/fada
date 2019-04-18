//Muchachos se me borró el de anoche no sé por qué, empecé a modificar de nuevo el que me enviaron, ya lo estoy arreglando ^^
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fada;

import java.util.Scanner;

/**
 *
 * @author miime_000
 */
public class Fada1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] m = new int[size][size];
		int[][] s = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = sc.nextInt();

			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				int y = j;
				int x = 0;
				while (i != j) {
					if (m[i][j] == 1) {
						x = x + 1;
						j++;
						y = j;
					} else {
						j++;
						y = j;
					}
				}
				int contador=0; //nos permitirá comparar si las posiciones anteriores son o no aliadas
                                while(contador<i+1){ //mientras se llega a la posición actual
                                    if(m[contador][j]==0){ //si es aliado
                                        s[contador][y]=1;
                                        contador++;
                                    }
                                }
				
				s[x][y] = 1;
				j = size;
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(s[i][j] + " ");
			}
		}
	}
}