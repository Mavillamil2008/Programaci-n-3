import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio 7:
 * Obtener dos arreglos tal que sus elementos sean los números pares
 * y números impares del arreglo A de 10 elementos.
 */
public class Ejercicio7 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arregloA = new int[10];

        // Llenar arreglo A con números aleatorios entre 1 y 50
        for (int i = 0; i < arregloA.length; i++) {
            arregloA[i] = random.nextInt(50) + 1;
        }

        // Contar la cantidad de pares e impares para dimensionar los arreglos
        int cantPares = 0;
        int cantImpares = 0;

        for (int num : arregloA) {
            if (num % 2 == 0) {
                cantPares++;
            } else {
                cantImpares++;
            }
        }

        // Crear arreglos del tamaño exacto requerido
        int[] pares = new int[cantPares];
        int[] impares = new int[cantImpares];

        // Clasificar los elementos
        int idxPar = 0;
        int idxImpar = 0;

        for (int num : arregloA) {
            if (num % 2 == 0) {
                pares[idxPar++] = num;
            } else {
                impares[idxImpar++] = num;
            }
        }

        // Mostrar resultados
        System.out.println("=== EJERCICIO 7: PARES E IMPARES ===");
        System.out.println("Arreglo A (10 elementos) : " + Arrays.toString(arregloA));
        System.out.println("Arreglo de Pares         : " + Arrays.toString(pares));
        System.out.println("Arreglo de Impares       : " + Arrays.toString(impares));
    }
}
