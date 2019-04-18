//Muchachos se me borró el de anoche no sé por qué, empecé a modificar de nuevo el que me enviaron, ya lo estoy arreglando ^^
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fada_project;

import java.util.Scanner;

/**
 *
 * @author miime_000
 */
public class FADA {

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
                                int contadori=i,contadorx=x;
                                while(contadori>0){
                                    contadori--;
                                    if(m[contadori][j]==1){
                                        while(contadorx>0){
                                            if(s[j][j]==1){
                                                contadorx--;
                                            }
                                        }
                                    }
                                }
                                s[x][y]=1;
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
