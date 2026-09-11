import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 13:
 * Dado un arreglo A de N elementos se desea almacenar los elementos mayores
 * y menores que la media (promedio) en vectores diferentes.
 */
public class Ejercicio13 {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 12; // Tamaño del arreglo
        int[] arregloA = new int[n];

        // Llenar con números aleatorios entre 1 y 100
        int suma = 0;
        for (int i = 0; i < n; i++) {
            arregloA[i] = random.nextInt(100) + 1;
            suma += arregloA[i];
        }

        // Calcular la media (promedio)
        double media = (double) suma / n;

        // Contar elementos mayores y menores que la media
        int cantMayores = 0;
        int cantMenores = 0;

        for (int num : arregloA) {
            if (num > media) {
                cantMayores++;
            } else if (num < media) {
                cantMenores++;
            }
        }

        // Crear arreglos con el tamaño adecuado
        int[] mayoresMedia = new int[cantMayores];
        int[] menoresMedia = new int[cantMenores];

        // Llenar los vectores
        int idxMay = 0;
        int idxMen = 0;

        for (int num : arregloA) {
            if (num > media) {
                mayoresMedia[idxMay++] = num;
            } else if (num < media) {
                menoresMedia[idxMen++] = num;
            }
        }

        // Mostrar resultados
        System.out.println("=== EJERCICIO 13: ELEMENTOS RESPECTO A LA MEDIA ===");
        System.out.println("Arreglo A (N=" + n + ")          : " + Arrays.toString(arregloA));
        System.out.println(String.format("Media (Promedio)             : %.2f", media));
        System.out.println("---------------------------------------------------");
        System.out.println("Mayores que la media (" + cantMayores + ") : " + Arrays.toString(mayoresMedia));
        System.out.println("Menores que la media (" + cantMenores + ") : " + Arrays.toString(menoresMedia));
    }
}
