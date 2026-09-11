import java.util.Random;

/**
 * Ejercicio 22:
 * Escribir un programa que lea las dimensiones de una matriz, lea y visualice la matriz 
 * y a continuación encuentre el mayor y menor elemento de la matriz y sus posiciones.
 */
public class Ejercicio22 {

    public static void main(String[] args) {
        // En un entorno de consola se puede ingresar por teclado con Scanner.
        // Aquí mostramos una ejecución demostrativa con valores predefinidos / generados.
        int n = 3; // Filas
        int m = 4; // Columnas

        int[][] matriz = new int[n][m];
        Random random = new Random();

        // Llenar matriz con valores aleatorios entre -50 y 50
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = random.nextInt(101) - 50;
            }
        }

        // Visualizar la matriz
        System.out.println("=== EJERCICIO 22: MAYOR Y MENOR ELEMENTO Y SUS POSICIONES ===");
        System.out.println("Matriz (" + n + " x " + m + "):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println();
        }

        // Inicializar mayor y menor con el primer elemento [0][0]
        int mayor = matriz[0][0];
        int filaMayor = 0, colMayor = 0;

        int menor = matriz[0][0];
        int filaMenor = 0, colMenor = 0;

        // Recorrer para buscar mayor y menor
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    filaMayor = i;
                    colMayor = j;
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    filaMenor = i;
                    colMenor = j;
                }
            }
        }

        // Imprimir hallazgos
        System.out.println("\n------------------------------------------------");
        System.out.println("Mayor elemento : " + mayor + " en posición [Fila " + filaMayor + ", Columna " + colMayor + "] (Base 0)");
        System.out.println("Menor elemento : " + menor + " en posición [Fila " + filaMenor + ", Columna " + colMenor + "] (Base 0)");
    }
}
