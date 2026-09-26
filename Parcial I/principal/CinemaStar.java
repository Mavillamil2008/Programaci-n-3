package principal;

import modelos.*; // Importamos todas las clases del paquete modelos
import java.util.Scanner;

/**
 * Clase principal que contiene el menú y ejecuta el programa (Método main).
 */
public class CinemaStar {
    
    public static void main(String[] args) {
        // Scanner para capturar lo que el usuario escribe en consola
        Scanner sc = new Scanner(System.in);
        
        // Arreglo para almacenar hasta 10 películas en el sistema
        Pelicula[] peliculas = new Pelicula[10]; 
        int totalPeliculas = 0; // Contador de cuántas películas llevamos creadas
        
        // Arreglo que define las salas existentes en el cine (2 normales, 1 3D)
        Sala[] salas = { new SalaNormal(1), new SalaNormal(2), new Sala3D(3) };
        
        // Arreglo para almacenar la programación (3 salas * 3 horarios = 9 máximo)
        Funcion[] funciones = new Funcion[9]; 
        int totalFunciones = 0; // Contador de funciones programadas

        // Bucle infinito para mantener el menú abierto hasta que el usuario decida salir
        while (true) {
            System.out.println("\n=== CINEMASTAR - MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Película");
            System.out.println("2. Asignar Función");
            System.out.println("3. Vender Entradas");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el "Enter" que queda en el Scanner tras leer el número

            if (opcion == 1) {
                // OPCIÓN 1: Registrar una nueva película
                if (totalPeliculas < peliculas.length) {
                    System.out.print("Nombre de la película: "); 
                    String nombre = sc.nextLine();
                    
                    System.out.print("Idioma: "); 
                    String idioma = sc.nextLine();
                    
                    System.out.print("Tipo (35mm o 3D): "); 
                    String tipo = sc.nextLine();
                    
                    System.out.print("Duración (min): "); 
                    int duracion = sc.nextInt();
                    
                    // Se crea el objeto Pelicula y se guarda en el arreglo
                    peliculas[totalPeliculas] = new Pelicula(nombre, idioma, tipo, duracion);
                    totalPeliculas++; // Incrementamos el contador
                    
                    System.out.println("Película registrada.");
                } else {
                    System.out.println("Memoria de películas llena.");
                }
            } 
            else if (opcion == 2) {
                // OPCIÓN 2: Programar una película en una sala y horario
                if (totalPeliculas == 0) {
                    System.out.println("Primero debe crear al menos una película.");
                    continue; // Vuelve al inicio del bucle
                }

                System.out.println("Películas disponibles:");
                // Imprimimos la lista de películas para que el usuario elija
                for (int i = 0; i < totalPeliculas; i++) {
                    System.out.println(i + ". " + peliculas[i].getNombre() + " (" + peliculas[i].getTipo() + ")");
                }
                
                System.out.print("Seleccione ID de película: "); 
                int idPeli = sc.nextInt();
                
                System.out.print("Seleccione Sala (1, 2 o 3): "); 
                int idSala = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
                System.out.print("Franja horaria (ej. 14:00 - 16:30): "); 
                String franja = sc.nextLine();

                // Obtenemos la sala seleccionada (restando 1 porque los arreglos empiezan en 0)
                Sala salaSeleccionada = salas[idSala - 1];
                Pelicula peliSeleccionada = peliculas[idPeli];

                // Verificamos si la sala elegida es compatible con el tipo de película usando Polimorfismo
                if (salaSeleccionada.aceptaPelicula(peliSeleccionada)) {
                    funciones[totalFunciones] = new Funcion(peliSeleccionada, salaSeleccionada, franja);
                    totalFunciones++;
                    System.out.println("Función asignada con éxito.");
                } else {
                    System.out.println("Error: Esta sala no permite el formato de la película.");
                }
            }
            else if (opcion == 3) {
                // OPCIÓN 3: Venta de boletos
                if (totalFunciones == 0) { 
                    System.out.println("No hay funciones programadas."); 
                    continue; 
                }
                
                System.out.println("Funciones programadas:");
                for (int i = 0; i < totalFunciones; i++) {
                    System.out.println(i + ". Sala " + funciones[i].getSala().getNumero() + 
                        " - " + funciones[i].getPelicula().getNombre() + 
                        " - " + funciones[i].getFranjaHoraria());
                }
                
                System.out.print("Seleccione el ID de la función: "); 
                int idFunc = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
                Funcion funcSeleccionada = funciones[idFunc];
                // Mostramos el estado actual de las sillas
                funcSeleccionada.mostrarMapa();
                
                System.out.print("Ingrese las sillas a comprar separadas por coma sin espacios (Ej: A3,B8,G4): ");
                String entradaSillas = sc.nextLine();
                
                // Dividimos el texto ingresado en un arreglo de Strings, separando por la coma
                String[] sillasComprar = entradaSillas.split(",");
                
                int totalPagar = 0;
                
                // Iteramos (recorremos) las sillas que el usuario digitó usando un for-each
                for (String s : sillasComprar) {
                    // .trim() quita espacios accidentales, .toUpperCase() asegura que la letra sea mayúscula
                    int precio = funcSeleccionada.venderEntrada(s.trim().toUpperCase());
                    totalPagar += precio; // Acumulamos el precio
                }
                
                System.out.println("\n*** TOTAL A PAGAR: $" + totalPagar + " ***");
                
                // Mostramos el mapa nuevamente para ver la actualización de las 'X' (sillas vendidas)
                funcSeleccionada.mostrarMapa();
            }
            else if (opcion == 4) {
                // OPCIÓN 4: Terminar el programa
                System.out.println("Cerrando aplicación CinemaStar...");
                break; // Rompe el bucle infinito while(true)
            }
            else {
                System.out.println("Opción inválida.");
            }
        }
        
        sc.close(); // Cerramos el escáner para liberar recursos y evitar fugas de memoria
    }
}
