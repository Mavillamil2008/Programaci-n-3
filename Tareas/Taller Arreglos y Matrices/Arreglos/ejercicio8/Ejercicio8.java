import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 8:
 * Elaborar un programa que lea (o genere) 30 números y que imprima
 * el número mayor, menor y el número de veces que se repiten ambos.
 */
public class Ejercicio8 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numeros = new int[30];

        // Generar 30 números aleatorios entre 1 y 50 para propiciar repeticiones
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(50) + 1;
        }

        // Primera pasada: determinar mayor y menor
        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }

        // Segunda pasada: contar cuantas veces se repiten mayor y menor
        int cantMayor = 0;
        int cantMenor = 0;

        for (int num : numeros) {
            if (num == mayor) {
                cantMayor++;
            }
            if (num == menor) {
                cantMenor++;
            }
        }

        // Mostrar resultados
        System.out.println("=== EJERCICIO 8: MAYOR, MENOR Y FRECUENCIAS ===");
        System.out.println("Arreglo de 30 números: " + Arrays.toString(numeros));
        System.out.println("------------------------------------------------");
        System.out.println("Número Mayor : " + mayor + " (se repite " + cantMayor + " vez/veces)");
        System.out.println("Número Menor : " + menor + " (se repite " + cantMenor + " vez/veces)");
    }
}
