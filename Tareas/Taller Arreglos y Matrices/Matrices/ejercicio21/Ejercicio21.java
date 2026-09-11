import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 21:
 * Dada una matriz de M*M elementos, hacer un programa que construya un vector B, 
 * donde cada uno de sus componentes sea la suma de los elementos de valores numéricos 
 * pares de las filas de la matriz.
 */
public class Ejercicio21 {

    public static void main(String[] args) {
        Random random = new Random();
        int m = 4; // Tamaño M de la matriz M x M
        int[][] matriz = new int[m][m];
        int[] vectorB = new int[m];

        // Llenar matriz con valores aleatorios entre 1 y 20
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = random.nextInt(20) + 1;
            }
        }

        // Calcular la suma de los elementos pares por cada fila
        for (int i = 0; i < m; i++) {
            int sumaPares = 0;
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] % 2 == 0) {
                    sumaPares += matriz[i][j];
                }
            }
            vectorB[i] = sumaPares;
        }

        // Imprimir resultados
        System.out.println("=== EJERCICIO 21: SUMA DE ELEMENTOS PARES POR FILA ===");
        System.out.println("Matriz " + m + "x" + m + ":");

        for (int i = 0; i < m; i++) {
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.printf("  --> Suma Pares = %d\n", vectorB[i]);
        }

        System.out.println();
        System.out.println("Vector B (Suma de pares de cada fila): " + Arrays.toString(vectorB));
    }
}
