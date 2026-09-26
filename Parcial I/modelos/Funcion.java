package modelos;
/**
 * Clase que agrupa una Película, una Sala y un Horario.
 * Es responsable de gestionar los asientos para una proyección específica.
 */
public class Funcion {
    // Relaciones (Composición/Agregación) con otras clases
    private Pelicula pelicula; // La película que se va a proyectar
    private Sala sala;         // La sala donde se hará la proyección
    private String franjaHoraria; // Horario de la función (ej. "14:00 - 16:00")
    
    // Matriz bidimensional para representar la cuadrícula de asientos de la sala
    private char[][] asientos; 

    /**
     * Constructor de una Función.
     * Asocia la película, la sala, el horario e inicializa la matriz de asientos.
     */
    public Funcion(Pelicula pelicula, Sala sala, String franjaHoraria) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.franjaHoraria = franjaHoraria;
        
        // Configuramos la cantidad de filas según el tipo de sala
        // (Uso del operador 'instanceof' para saber de qué clase es un objeto)
        int numFilas = (sala instanceof SalaNormal) ? 8 : 6;
        
        // Creamos la matriz: filas variables x 12 columnas (máximo)
        asientos = new char[numFilas][12];
        
        // Ciclos anidados para inicializar todos los asientos como disponibles ('-')
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < 12; j++) {
                asientos[i][j] = '-';
            }
        }
    }

    /**
     * Muestra en consola el mapa visual de asientos de la función.
     */
    public void mostrarMapa() {
        System.out.println("\n--- Pantalla Sala " + sala.getNumero() + " ---");
        
        // Recorremos la matriz desde la última fila hacia la primera 
        // para que en la consola se vea la pantalla arriba y la fila A abajo (como un cine real)
        for (int i = asientos.length - 1; i >= 0; i--) {
            // Convertimos el índice numérico (0, 1, 2...) a letra ('A', 'B', 'C'...)
            char letra = (char) ('A' + i);
            System.out.print(letra + "  "); // Imprime la letra de la fila al inicio
            
            // Recorremos las columnas (asientos de esa fila)
            for (int j = 0; j < 12; j++) {
                // Validación especial: Las filas G y H solo tienen 9 sillas (columnas 0 a 8)
                // Si estamos en esas filas y en la columna 9, 10 u 11, imprimimos espacios vacíos.
                if ((letra == 'G' || letra == 'H') && j >= 9) {
                    System.out.print("  "); 
                } else {
                    // Imprimimos el estado del asiento ('-' disponible, 'X' ocupado)
                    System.out.print(asientos[i][j] + " ");
                }
            }
            System.out.println(); // Salto de línea para pasar a la siguiente fila
        }
    }

    /**
     * Procesa la compra de un asiento específico.
     * @param silla Código de la silla (ej. "A1", "G5", "C12").
     * @return El precio pagado por la silla. Retorna 0 si hay algún error.
     */
    public int venderEntrada(String silla) {
        // Extraer la fila (letra) y la columna (número)
        char fila = silla.charAt(0);
        // Extraemos el número desde el segundo carácter (índice 1) en adelante, y restamos 1 porque las matrices inician en 0
        int col = Integer.parseInt(silla.substring(1)) - 1; 
        
        // Convertimos la letra a índice de fila ('A' -> 0, 'B' -> 1, etc.)
        int indiceFila = fila - 'A';

        // Validaciones: que el asiento esté dentro de los límites de la matriz
        if (indiceFila < 0 || indiceFila >= asientos.length || col < 0 || col >= 12 
            || ((fila == 'G' || fila == 'H') && col >= 9)) {
            System.out.println("Error: La silla " + silla + " no existe en esta sala.");
            return 0; // Venta fallida
        }

        // Validación: que el asiento no haya sido comprado antes
        if (asientos[indiceFila][col] == 'X') {
            System.out.println("Error: La silla " + silla + " ya está ocupada.");
            return 0; // Venta fallida
        }

        // Venta exitosa: marcamos con 'X'
        asientos[indiceFila][col] = 'X';
        
        // Calculamos el precio delegando la responsabilidad a la sala correspondiente
        int precio = sala.calcularPrecio(fila);
        System.out.println("Silla " + silla + " asignada. Precio: $" + precio);
        
        return precio;
    }

    // --- Getters para acceder a la información desde otras clases ---
    
    public Sala getSala() {
        return sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }
}
