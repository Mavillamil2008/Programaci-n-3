import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 12:
 * Dado un arreglo A de N elementos se quiere generar otro arreglo que contenga
 * las posiciones de los elementos del arreglo dado que sean iguales a un valor x dado.
 *
 * Ejemplo: Arreglo A = (4,6,8,2,6,9,6,1), X = 6 -> Arreglo B = (2,5,7) (posiciones base 1)
 */
public class Ejercicio12 {

    public static void main(String[] args) {
        // Demostración 1: Arreglo del ejemplo del problema
        int[] arregloEjemplo = {4, 6, 8, 2, 6, 9, 6, 1};
        int xEjemplo = 6;
        int[] resultadoEjemplo = obtenerPosiciones(arregloEjemplo, xEjemplo);

        System.out.println("=== EJERCICIO 12: POSICIONES DE UN VALOR X ===");
        System.out.println("--- Demostración con Arreglo de Ejemplo ---");
        System.out.println("Arreglo A           : " + Arrays.toString(arregloEjemplo));
        System.out.println("Valor X a buscar    : " + xEjemplo);
        System.out.println("Arreglo B (posic.)  : " + Arrays.toString(resultadoEjemplo));
        System.out.println();

        // Demostración 2: Arreglo aleatorio de N elementos
        Random random = new Random();
        int n = 15;
        int[] arregloA = new int[n];
        for (int i = 0; i < n; i++) {
            arregloA[i] = random.nextInt(10) + 1;
        }
        int xAleatorio = random.nextInt(10) + 1;
        int[] resultadoAleatorio = obtenerPosiciones(arregloA, xAleatorio);

        System.out.println("--- Demostración con N (" + n + ") Elementos Aleatorios ---");
        System.out.println("Arreglo A           : " + Arrays.toString(arregloA));
        System.out.println("Valor X a buscar    : " + xAleatorio);
        System.out.println("Arreglo B (posic.)  : " + Arrays.toString(resultadoAleatorio));
    }

    /**
     * Retorna un arreglo con las posiciones (base 1) donde el elemento es igual a X.
     */
    public static int[] obtenerPosiciones(int[] arreglo, int x) {
        // Contar ocurrencias de X
        int contador = 0;
        for (int num : arreglo) {
            if (num == x) {
                contador++;
            }
        }

        // Crear arreglo de posiciones con tamaño exacto
        int[] posiciones = new int[contador];
        int idx = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == x) {
                posiciones[idx++] = i + 1; // Posición base 1 (según el ejemplo del enunciado)
            }
        }

        return posiciones;
    }
}
