package modelos;

/**
 * Clase abstracta que representa una sala de cine genérica.
 * No se pueden crear objetos directamente de Sala, sirve como "plantilla" 
 * para las clases hijas (SalaNormal, Sala3D) aplicando Herencia y Polimorfismo.
 */
public abstract class Sala {
    // Atributo protegido para que las clases hijas puedan acceder a él
    protected int numero; // Número que identifica la sala en el cine

    /**
     * Constructor de la clase base Sala.
     */
    public Sala(int numero) {
        this.numero = numero;
    }
    
    // Método para obtener el número de la sala
    public int getNumero() {
        return numero;
    }

    // --- Métodos abstractos (Polimorfismo) ---
    // Cada sala hija (Normal o 3D) deberá implementar estos métodos a su manera.

    /**
     * Calcula el precio de la entrada dependiendo de la fila y el tipo de sala.
     * @param fila Letra de la fila donde se comprará el asiento.
     * @return El precio de la silla.
     */
    public abstract int calcularPrecio(char fila);

    /**
     * Verifica si la sala tiene la tecnología para proyectar una película específica.
     * @param p La película que se desea proyectar.
     * @return true si la sala acepta la película, false en caso contrario.
     */
    public abstract boolean aceptaPelicula(Pelicula p);
}
