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
public class Dinamic {

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
                for (int i=0; i<size; i++) {
                    for (int j = 0; j < size; j++) {
                    int y=0;
                    int x=0;
                        if(i==0 && j==i){
                            s[x][y]=1;
                        }
                        while(i!=j){
                            if(m[i][j]==1){
                                if (s[x][y]==1){
                                    if(s[y][y]==1){
                                        x++;
                                    }
                                    else{
                                        x++;
                                        j=0;
                                    }
                                }
                            }
                            j++;
                            y=j;
			}
			s[x][y] = 1;
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

/*5
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0*/

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
