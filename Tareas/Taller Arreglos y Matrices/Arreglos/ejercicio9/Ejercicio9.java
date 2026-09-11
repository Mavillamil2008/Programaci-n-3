import java.util.Arrays;
import java.util.Random;
/**
 * Ejercicio 9:
 * Dado como entrada un arreglo unidimensional de enteros y un número entero,
 * determine cuántas veces se encuentra este número dentro del arreglo.
 */
public class Ejercicio9 {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 20; // Tamaño del arreglo
        int[] arreglo = new int[n];

        // Llenar el arreglo con números aleatorios entre 1 y 15
        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextInt(15) + 1;
        }

        // Definir el número a buscar (se puede pedir por consola o asignarlo aleatoriamente)
        int numeroBuscado = random.nextInt(15) + 1;

        // Buscar y contar ocurrencias
        int contador = 0;
        for (int num : arreglo) {
            if (num == numeroBuscado) {
                contador++;
            }
        }

        // Mostrar resultados
        System.out.println("=== EJERCICIO 9: CONTAR OCURRENCIAS DE UN NÚMERO ===");
        System.out.println("Arreglo generado : " + Arrays.toString(arreglo));
        System.out.println("Número buscado   : " + numeroBuscado);
        System.out.println("El número " + numeroBuscado + " se encuentra " + contador + " vez/veces en el arreglo.");
    }
}
