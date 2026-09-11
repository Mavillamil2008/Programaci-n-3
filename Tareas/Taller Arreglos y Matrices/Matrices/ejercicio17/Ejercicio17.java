import java.util.Random;

/**
 * Ejercicio 17:
 * Sumar los elementos de cada fila y cada columna de una matriz.
 */
public class Ejercicio17 {

    public static void main(String[] args) {
        Random random = new Random();
        int filas = 4;
        int columnas = 5;
        int[][] matriz = new int[filas][columnas];

        // Llenar matriz con números aleatorios entre 1 y 20
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(20) + 1;
            }
        }

        // Arreglos para almacenar las sumas
        int[] sumaFilas = new int[filas];
        int[] sumaColumnas = new int[columnas];

        // Calcular sumas de filas y columnas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sumaFilas[i] += matriz[i][j];
                sumaColumnas[j] += matriz[i][j];
            }
        }

        // Imprimir resultados de forma tabulada
        System.out.println("=== EJERCICIO 17: SUMA DE FILAS Y COLUMNAS DE UNA MATRIZ ===");
        System.out.println("Matriz de " + filas + "x" + columnas + ":\n");

        // Cabecera de columnas
        for (int j = 0; j < columnas; j++) {
            System.out.printf("%6s", "Col " + (j + 1));
        }
        System.out.printf(" | %8s\n", "Suma Fila");
        System.out.println("-------------------------------------------------------");

        // Imprimir cuerpo de la matriz y suma de filas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.printf(" | %8d\n", sumaFilas[i]);
        }

        System.out.println("-------------------------------------------------------");
        // Imprimir suma de columnas
        for (int j = 0; j < columnas; j++) {
            System.out.printf("%6d", sumaColumnas[j]);
        }
        System.out.printf(" | %8s\n", "Suma Col");
    }
}
