/**
 * 
 */
package fada;

import java.util.Scanner;

/**
 * @author Stiven®
 * @date 17/04/2019
 * @time 10:42:05 a. m.
 */
public class Dinamica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] m = new int[size][size];
		int[][] s = new int[size][size];
		int villas = 1;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = sc.nextInt();

			}
		}
		
		for (int i = 0; i < size; i++) {
			int j = 0, y = 0;

			/*
			 * verifica si hay o no relacion amistosa con todos los paises que se encuentren
			 * alojados hasta el momento
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
			s[y][j] = 1;					//Ubica al pais en su villa correspondiente
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
