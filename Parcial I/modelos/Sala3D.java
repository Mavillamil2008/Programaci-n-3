package modelos;

/**
 * Representa una sala de cine con tecnología 3D.
 * Hereda de la clase abstracta Sala.
 */
public class Sala3D extends Sala {
    
    public Sala3D(int numero) {
        super(numero); // "super" llama al constructor de Sala y le pasa el número
    }

    /**
     * Calcula el precio en la sala 3D.
     * Aquí no importa la fila, toda silla tiene el mismo costo.
     */
    @Override
    public int calcularPrecio(char fila) {
        return 10000; // Tarifa única para sala 3D
    }

    /**
     * Verifica si la película es compatible con la sala.
     * La sala 3D solo puede proyectar películas en formato "3D".
     */
    @Override
    public boolean aceptaPelicula(Pelicula p) {
        return p.getTipo().equalsIgnoreCase("3D"); 
    }
}
