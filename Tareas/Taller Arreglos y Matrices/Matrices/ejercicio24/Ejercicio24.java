import java.util.Random;

/**
 * Ejercicio 24:
 * Producción total de toneladas de cereales (arroz, avena, cebada, trigo) cosechadas
 * durante cada mes del año anterior.
 *
 * Determinar:
 * a. El promedio anual de toneladas cosechadas.
 * b. Cuántos meses tuvieron una cosecha superior al promedio anual.
 * c. Cuántos meses tuvieron una cosecha inferior al promedio anual.
 * d. Cuál fue el mes en que se produjeron mayor número de toneladas.
 */
public class Ejercicio24 {

    public static void main(String[] args) {
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        String[] cereales = {"Arroz", "Avena", "Cebada", "Trigo"};

        int numMeses = 12;
        int numCereales = 4;
        double[][] produccion = new double[numMeses][numCereales];
        Random random = new Random();

        // Generar toneladas aleatorias cosechadas por mes y cereal (entre 100 y 500 toneladas)
        for (int i = 0; i < numMeses; i++) {
            for (int j = 0; j < numCereales; j++) {
                produccion[i][j] = 100 + random.nextDouble() * 400;
            }
        }

        // Calcular la producción total de cada mes (suma de los 4 cereales)
        double[] totalMensual = new double[numMeses];
        double sumaTotalAnual = 0;

        for (int i = 0; i < numMeses; i++) {
            double sumaMes = 0;
            for (int j = 0; j < numCereales; j++) {
                sumaMes += produccion[i][j];
            }
            totalMensual[i] = sumaMes;
            sumaTotalAnual += sumaMes;
        }

        // a. Promedio anual de toneladas cosechadas (promedio por mes)
        double promedioAnualMensual = sumaTotalAnual / numMeses;

        // b, c, d: Contar meses superiores, inferiores y hallar el mes de mayor producción
        int mesesSuperiores = 0;
        int mesesInferiores = 0;
        int idxMesMayor = 0;
        double mayorCosecha = totalMensual[0];

        for (int i = 0; i < numMeses; i++) {
            if (totalMensual[i] > promedioAnualMensual) {
                mesesSuperiores++;
            } else if (totalMensual[i] < promedioAnualMensual) {
                mesesInferiores++;
            }

            if (totalMensual[i] > mayorCosecha) {
                mayorCosecha = totalMensual[i];
                idxMesMayor = i;
            }
        }

        // Imprimir reporte de producción
        System.out.println("=== EJERCICIO 24: REPORTE ANUAL DE PRODUCCIÓN DE CEREALES ===");
        System.out.println();
        System.out.printf("%-12s | %10s %10s %10s %10s | %14s\n", "Mes", "Arroz", "Avena", "Cebada", "Trigo", "Total Mes (t)");
        System.out.println("----------------------------------------------------------------------------------");

        for (int i = 0; i < numMeses; i++) {
            System.out.printf("%-12s | %10.2f %10.2f %10.2f %10.2f | %14.2f\n",
                    meses[i], produccion[i][0], produccion[i][1], produccion[i][2], produccion[i][3], totalMensual[i]);
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("PRODUCCIÓN TOTAL ANUAL: %.2f toneladas\n\n", sumaTotalAnual);

        // Respuestas a las preguntas del ejercicio
        System.out.println("--- RESULTADOS Y ANÁLISIS ---");
        System.out.printf("a. Promedio mensual anual de cosechas : %.2f toneladas\n", promedioAnualMensual);
        System.out.println("b. Meses con cosecha SUPERIOR al promedio  : " + mesesSuperiores + " meses");
        System.out.println("c. Meses con cosecha INFERIOR al promedio  : " + mesesInferiores + " meses");
        System.out.printf("d. Mes con MAYOR número de toneladas       : %s (%.2f toneladas)\n",
                meses[idxMesMayor], mayorCosecha);
    }
}
