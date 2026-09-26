public class OperacionesConArreglos {
    /**
     * Calcula la suma de elementos opuestos: A[i] + A[N - 1 - i].
     * Si N es impar, el elemento central se mantiene igual (o se suma consigo mismo según corresponda).
     */
    public int[] calcularSumaOpuestos(int[] arreglo) {
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
