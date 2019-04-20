/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingenua;

import java.util.Scanner;

/**
 *
 * @author miime_000
 */
public class PIngenua {

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
                
                //for (int i=0; i<size; i++) {
                    for (int j = 0; j < size; j++) {
                        int i=0;
                        if(m[i][j]==1){
                            s[i+1][j]=1;
                        }
                        else{
                            s[i][j]=1;
                        }
                    }
                //}
                 
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
