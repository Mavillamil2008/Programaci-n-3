/**
 * Ejercicio 19:
 * Codificar un programa que genere una matriz de n x m, en la cual asigne ceros 
 * a todos los elementos, excepto a los de la diagonal principal (i == j) donde se asignarán unos.
 */
public class Ejercicio19 {

    public static void main(String[] args) {
        int n = 5; // Número de filas
        int m = 5; // Número de columnas
        int[][] matriz = new int[n][m];

        // Llenar la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }

        // Imprimir la matriz
        System.out.println("=== EJERCICIO 19: MATRIZ CON UNOS EN LA DIAGONAL PRINCIPAL ===");
        System.out.println("Dimensiones: " + n + " x " + m + "\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
