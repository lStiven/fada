/**
 * 
 */
package fada;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Stiven�
 * @date 22/04/2019
 * @time 5:33:31 p. m.
 */
public class Villas2 {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		// Lectura de archivo de texto
		final String nomFichero = "M4.txt";
		int size;
		int[][] m = null;
		int[][] s = null;
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
			size = Integer.parseInt(tamano);
			m = new int[size][size];
			s = new int[size][size];
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
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * cuenta cuantas relaciones amistosas tiene cada pais
		 */
		int cont = 0;
		int[] amistades = new int[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (m[i][j] == 0)
					cont++;

			}
			amistades[i] = cont;
			cont = 0;
		}

		// copia del arrglo anterior
		int[] k = new int[size];

		for (int i = 0; i < amistades.length; i++) {
			k[i] = amistades[i];
		}

		// Se ordena de mayor a menor(numero de relaciones amistosas)
		ordenar(k);

		/*
		 * Ubica a cada pais en su villa correspondiente, empezando por el que mas
		 * relaciones amistosas tenga
		 */

		int villas = 1;
		int y, aux;
		for (int i = 0; i < size; i++) {
			int j = 0;
			y = 0;
			aux = k[i];
			while (size != j) {
				if (s[y][j] == 1) {
					if (m[aux][j] == 1) {
						y++;
						j = 0;
						if (y > villas)
							villas = y;

					} else {
						j++;
					}
				} else {
					j++;
				}
			}
			s[y][aux] = 1;
		}
		// Imprime los paises en sus correspondientes villas
		for (int i = 0; i <= villas; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(s[i][j] + " ");
			}
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	// Algoritmo de ordenamiento ShellSort
	public static void ordenar2(int[] v) {
		final int N = v.length;
		int incremento = N;
		do {
			incremento = incremento / 2;
			for (int k = 0; k < incremento; k++) {
				for (int i = incremento + k; i < N; i += incremento) {
					int j = i;
					while (j - incremento >= 0 && v[j] < v[j - incremento]) {
						int tmp = v[j];
						v[j] = v[j - incremento];
						v[j - incremento] = tmp;
						j -= incremento;
					}
				}
			}
		} while (incremento > 1);
	}

	// Algoritmo de ordenamiento Burbuja
	public static void ordenar(int[] V) {
		int aux;
		int aux2;
		int[] indice = new int[V.length];
		for (int i = 0; i < indice.length; i++) {
			indice[i] = i;
		}

		for (int i = 0; i < V.length - 1; i++) {
			for (int j = i + 1; j < V.length; j++) {
				if (V[i] < V[j]) {
					aux = V[i];
					V[i] = V[j];
					V[j] = aux;
					aux2 = indice[i];
					indice[i] = indice[j];
					indice[j] = aux2;
				}
			}
		}

		for (int i = 0; i < indice.length; i++) {
			V[i] = indice[i];
		}
	}

}
