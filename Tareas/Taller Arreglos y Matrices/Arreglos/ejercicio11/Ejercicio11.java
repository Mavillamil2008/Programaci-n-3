import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 11:
 * Dado un arreglo A de N elementos se desea generar tres arreglos que contengan
 * los elementos negativos, cero y positivos del arreglo inicial.
 */
public class Ejercicio11 {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 15; // N elementos
        int[] arregloA = new int[n];

        // Llenar con números entre -10 y 10 (incluye negativos, ceros y positivos)
        for (int i = 0; i < n; i++) {
            arregloA[i] = random.nextInt(21) - 10;
        }

        // Contar la cantidad de cada categoría
        int cantNeg = 0;
        int cantCeros = 0;
        int cantPos = 0;

        for (int num : arregloA) {
            if (num < 0) {
                cantNeg++;
            } else if (num == 0) {
                cantCeros++;
            } else {
                cantPos++;
            }
        }

        // Crear arreglos con tamaño exacto
        int[] negativos = new int[cantNeg];
        int[] ceros = new int[cantCeros];
        int[] positivos = new int[cantPos];

        // Llenar arreglos
        int idxNeg = 0, idxZero = 0, idxPos = 0;
        for (int num : arregloA) {
            if (num < 0) {
                negativos[idxNeg++] = num;
            } else if (num == 0) {
                ceros[idxZero++] = num;
            } else {
                positivos[idxPos++] = num;
            }
        }

        // Mostrar resultados
        System.out.println("=== EJERCICIO 11: NEGATIVOS, CEROS Y POSITIVOS ===");
        System.out.println("Arreglo Inicial A (N=" + n + ") : " + Arrays.toString(arregloA));
        System.out.println("---------------------------------------------------");
        System.out.println("Arreglo Negativos (" + cantNeg + ")   : " + Arrays.toString(negativos));
        System.out.println("Arreglo Ceros (" + cantCeros + ")       : " + Arrays.toString(ceros));
        System.out.println("Arreglo Positivos (" + cantPos + ")   : " + Arrays.toString(positivos));
    }
}
