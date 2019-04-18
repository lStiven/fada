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
		int villas = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = sc.nextInt();

			}
		}
		
		for (int i = 0; i < size; i++) {
			int j = 0, y = 0;

			/*
			 * verifica si hay o no relacion amistosa con todos los paises que se encuentren alojados
			 * hasta el momento
			 */
			while (i != j) {
				if (s[y][j] == 1) {			//Primero verifica si hay un pais alojado en esa villa
					if (m[i][j] == 1) {		//Comprueba si existen relaciones diplomaticas no amistosas
						y++;				//Si las hay, cambia a la siguiente villa o crea una nueva
						j = 0;				
						if (y > villas)
							villas = y;		//Lleva el conteo de villas creadas

					} else {
						j++;
					}
				} else {
					j++;
				}
			}
                        int contador=0; //nos permitirá comparar si las posiciones anteriores son o no aliadas
                        while(contador<i+1){ //mientras se llega a la posición actual
                            if(m[contador][j]==0){ //si es aliado
                                s[contador][y]=1; //se ubica un 1 en la posición
                                contador++;
                            }
                        }
			//s[y][j] = 1;					//Ubica al pais en su villa correspondiente
		}

		//Muestra el numero de villas con sus huespedes
		for (int i = 0; i <= villas; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(s[i][j] + " ");
			}
		}

	}

}
