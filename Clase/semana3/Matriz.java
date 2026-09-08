public class Matriz {
    public static void main(String[] args) {
        
        // Declaración de una matriz (forma 1)

        int[][] m = {
                    {5, 8, 6}, 
                    {1, 3, 2},
                    {4, 9, 7}
                };
        // Recorrer la matriz

        for (int i = 0; i < m.length; i++) {    //m.length siempre para las filas
            for (int j = 0; j < m[0].length; j++) {     //m[0].length siempre para las columnas
                System.out.print("m[" + i + "][" + j + "] = " + m[i][j] + " ");
            }
            System.out.println();
        }

        // Matreiz visualmente mejor

        String cad = "";
        for (int i = 0; i < m.length; i++) {    //m.length siempre para las filas
            for (int j = 0; j < m[0].length; j++) {     //m[0].length siempre para las columnas     
                cad += "|" + m[i][j] + " ";
            }
            cad += "|\n";
        }
        System.out.println(cad);
    }

}
