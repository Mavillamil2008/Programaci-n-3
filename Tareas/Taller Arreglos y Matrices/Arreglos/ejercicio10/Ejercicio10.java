import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 10:
 * Dado un arreglo A de N elementos se desea crear otro arreglo B,
 * tal que cada uno de sus elementos sea la suma de los opuestos en el arreglo dado.
 *
 * Ejemplo: Arreglo A = (8,5,3,10,2,8,1) -> Arreglo B = (9,13,5,10) [o según especificación]
 */
public class Ejercicio10 {

    public static void main(String[] args) {
        // Ejemplo 1: Con el arreglo propuesto en el enunciado
        int[] arregloEjemplo = {8, 5, 3, 10, 2, 8, 1};
        int[] resultadoEjemplo = calcularSumaOpuestos(arregloEjemplo);

        System.out.println("=== EJERCICIO 10: SUMA DE ELEMENTOS OPUESTOS ===");
        System.out.println("--- Demostración con Arreglo de Ejemplo ---");
        System.out.println("Arreglo A : " + Arrays.toString(arregloEjemplo));
        System.out.println("Arreglo B : " + Arrays.toString(resultadoEjemplo));
        System.out.println();

        // Ejemplo 2: Generación con N elementos aleatorios
        Random random = new Random();
        int n = 10; // Tamaño N
        int[] arregloA = new int[n];
        for (int i = 0; i < n; i++) {
            arregloA[i] = random.nextInt(20) + 1;
        }

        int[] arregloB = calcularSumaOpuestos(arregloA);
        System.out.println("--- Demostración con N (" + n + ") Elementos Aleatorios ---");
        System.out.println("Arreglo A : " + Arrays.toString(arregloA));
        System.out.println("Arreglo B : " + Arrays.toString(arregloB));
    }

    /**
     * Calcula la suma de elementos opuestos: A[i] + A[N - 1 - i].
     * Si N es impar, el elemento central se mantiene igual (o se suma consigo mismo según corresponda).
     */
    public static int[] calcularSumaOpuestos(int[] arreglo) {
        int n = arreglo.length;
        int tamB = (n + 1) / 2; // Redondeo hacia arriba para incluir el elemento medio si N es impar
        int[] B = new int[tamB];

        for (int i = 0; i < tamB; i++) {
            int opuestoIdx = n - 1 - i;
            if (i == opuestoIdx) {
                // Elemento central en un arreglo de tamaño impar
                B[i] = arreglo[i];
            } else {
                B[i] = arreglo[i] + arreglo[opuestoIdx];
            }
        }
        return B;
    }
}
