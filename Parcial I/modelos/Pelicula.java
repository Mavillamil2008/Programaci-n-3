package modelos;

/**
 * Clase que representa una película en el cine.
 * Demuestra el principio de Encapsulamiento, ocultando sus atributos (private)
 * y permitiendo el acceso solo a través de métodos (getters/setters).
 */
public class Pelicula {
    // Variables de la clase (Atributos)
    private String nombre; // El título de la película
    private String idioma; // El idioma en que se proyectará (ej. Español, Inglés subtitulado)
    private String tipo;   // El formato de la película, puede ser "35mm" (tradicional) o "3D"
    private int duracion;  // Tiempo de duración de la película en minutos

    /**
     * Constructor de la clase Pelicula.
     * Se ejecuta al crear un nuevo objeto Pelicula para inicializar sus datos.
     */
    public Pelicula(String nombre, String idioma, String tipo, int duracion) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    // --- Getters y Setters para acceder a la información de forma segura ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
