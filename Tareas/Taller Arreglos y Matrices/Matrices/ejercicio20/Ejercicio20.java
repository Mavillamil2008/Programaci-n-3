import java.util.Random;

/**
 * Ejercicio 20:
 * Codificar un programa que genere una matriz 10 x 10 con ceros en la diagonal principal hacia arriba.
 * (Elementos donde col >= fila se asignan en 0; elementos bajo la diagonal se llenan con valores).
 */
public class Ejercicio20 {

    public static void main(String[] args) {
        int n = 10;
        int[][] matriz = new int[n][n];
        Random random = new Random();

        // Generar la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) { // Diagonal principal y hacia arriba (triangular superior incluida la diagonal)
                    matriz[i][j] = 0;
                } else { // Por debajo de la diagonal principal
                    matriz[i][j] = random.nextInt(9) + 1; // Números entre 1 y 9
                }
            }
        }

        // Mostrar la matriz resultante
        System.out.println("=== EJERCICIO 20: MATRIZ 10x10 CON CEROS EN Y SOBRE LA DIAGONAL PRINCIPAL ===");
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
