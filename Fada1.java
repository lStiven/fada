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
		int x=0;
                int y=0;
                for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
                            y=i;
                            x=0;
                            if(i==0 && j==i){
                                s[x][y]=1;
                            }
                            if(m[i][j]==1){
                                if(s[j][j]==1){
                                    x++;
                                }
                                s[x][y]=1;
                            }
                            else{
                                s[x][y]=1;
                            }
                            j=size;
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
/*9
0 1 1 0 0 1 0 0 0
1 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0
0 0 0 0 0 1 0 1 1
1 1 0 0 1 0 0 0 0
0 1 0 1 0 0 0 0 0
0 0 0 0 1 0 0 0 0
0 1 0 0 1 0 0 0 0*/
