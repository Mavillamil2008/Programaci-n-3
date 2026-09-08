import java.util.Random;

public class Ejecutar {
    public static void main(String[] args) {

        // Forma 1 - Creación del arreglo
        int[] a = {2, 8, 10, 6, 15, 20, 21, 1, 3, 12};

        // Recorrer el arreglo a
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        // Forma 2 - Llenando el arreglo de manera aleatoria
        Random r = new Random();
        int[] b = new int[10];

        for (int i = 0; i < b.length; i++) {
            b[i] = r.nextInt(100); // genera números aleatorios del 0 al 99
        }

        // Mostrar el arreglo aleatorio
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
    
        }
    }
}
