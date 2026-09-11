/**
 * Ejercicio 18:
 * Realice un programa que calcule la tabla de multiplicar del 1 al 10 
 * almacenando los valores en una tabla. Imprimir dicha tabla.
 */
public class Ejercicio18 {

    public static void main(String[] args) {
        int n = 10;
        int[][] tabla = new int[n][n];

        // Llenar la matriz con las tablas de multiplicar del 1 al 10
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tabla[i][j] = (i + 1) * (j + 1);
            }
        }

        // Mostrar la tabla de multiplicar de forma tabular
        System.out.println("=== EJERCICIO 18: TABLA DE MULTIPLICAR DEL 1 AL 10 ===");
        System.out.println();

        // Encabezado de columnas
        System.out.printf("%5s |", "x");
        for (int col = 1; col <= n; col++) {
            System.out.printf("%5d", col);
        }
        System.out.println();
        System.out.println("------+" + "----".repeat(n + 3));

        // Filas de la tabla
        for (int i = 0; i < n; i++) {
            System.out.printf("%5d |", (i + 1));
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", tabla[i][j]);
            }
            System.out.println();
        }
    }
}
