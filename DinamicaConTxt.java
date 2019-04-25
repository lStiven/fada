/**
 * 
 */
package fada;

/**
 * @author Stiven�
 */
import java.io.FileReader;
import java.io.IOException;

public class DinamicaConTxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String nomFichero = "M9.txt";
		try (FileReader fr = new FileReader(nomFichero)) {
			int valor = fr.read();
			String tamano = "";
			/*
			 * Se lee el primer valor, para saber el tamaño de los arreglos m y s
			 * respectivamente
			 */
			if (valor != 48 && valor != 49) {
				tamano = Character.toString((char) valor);
			}
			int size = Integer.parseInt(tamano);
			int[][] m = new int[size][size];
			int[][] s = new int[size][size];
			/* Continuación de lectura */
			/* Saltos para evitar leer espacios en blanco */
			for (int i = 0; i < 3; i++) {
				valor = fr.read();
			}
			int x = 0, z = 0;
			/* Mientras el archivo contenga valores, se leerá cada posición */
			while (valor != -1) {
				/* en ASCII 32 es el espacio, así que no es necesario tenerlo en cuenta */
				if (valor != 32) {
					if (z < size) {
						/* como los valores están en ASCII (char) los convertimos a enteros */
						m[x][z] = Character.getNumericValue((char) valor);
						z++;
						/* se continúa con la lectura de archivo */
						valor = fr.read();
					}
					/* En caso de haber llegado a la posición horizontal final */
					else {
						z = 0;
						x++;
					}
				}
				/* Continuamos con la lectura de los datos que siguen en el archivo */
				valor = fr.read();
			}
			System.out.print("////////////MATRIZ M//////////\n");
			/* matriz m */
			for (int t = 0; t < size; t++) {
				System.out.println();
				for (int n = 0; n < size; n++) {
					System.out.print(m[t][n] + " ");
				}
			}

			int villas = 0;
			for (int i = 0; i < size; i++) {
				int j = 0, y = 0;

				/*
				 * verifica si hay o no relacion amistosa con todos los paises que se encuentren
				 * alojados hasta el momento
				 */
				while (i != j) {
					if (s[y][j] == 1) { // Primero verifica si hay un pais alojado en esa villa
						if (m[i][j] == 1) { // Comprueba si existen relaciones diplomaticas no amistosas
							y++; // Si las hay, cambia a la siguiente villa o crea una nueva
							j = 0;
							if (y > villas)
								villas = y; // Lleva el conteo de villas creadas
						} else {
							j++;
						}
					} else {
						j++;
					}
				}
				s[y][j] = 1; // Ubica al pais en su villa correspondiente
			}

			System.out.println("\n\n////////////VILLAS//////////");
			// Muestra el numero de villas con sus huespedes
			for (int i = 0; i <= villas; i++) {
				System.out.println();
				for (int j = 0; j < size; j++) {
					System.out.print(s[i][j] + " ");
				}
			}
		} catch (IOException e) {
			System.out.println("Problemas con el E/S " + e);
		}
	}
}
