package modelos;

/**
 * Representa una sala de cine tradicional (no 3D).
 * Hereda de la clase Sala.
 */
public class SalaNormal extends Sala {
    
    /**
     * Constructor que llama al constructor de la clase padre (Sala).
     */
    public SalaNormal(int numero) {
        super(numero); // "super" llama al constructor de Sala y le pasa el número
    }

    /**
     * Sobrescribe (Override) el método para calcular el precio en una sala normal.
     * Las filas G y H son preferenciales, las demás son generales.
     */
    @Override
    public int calcularPrecio(char fila) {
        // La zona preferencial vale $12.000 y la General $8.000
        if (fila == 'G' || fila == 'H') {
            return 12000; 
        }
        return 8000; 
    }

    /**
     * Sobrescribe el método para validar qué película puede proyectar.
     * Una sala normal solo puede proyectar películas en formato "35mm".
     */
    @Override
    public boolean aceptaPelicula(Pelicula p) {
        // Ignora mayúsculas/minúsculas al comparar ("35mm" o "35MM")
        return p.getTipo().equalsIgnoreCase("35mm"); 
    }
}
