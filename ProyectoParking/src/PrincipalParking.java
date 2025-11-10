import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del programa.
 * Crea un aparcamiento y lanza varios hilos (coches) para simular la concurrencia.
 */
public class PrincipalParking {

    public static void main(String[] args) {

        // Creamos el aparcamiento con una capacidad de 3 plazas.
        Aparcamiento aparcamiento = new Aparcamiento(3);

        // Lista para guardar los hilos de los coches (solo para poder hacer join después).
        List<Thread> hilos = new ArrayList<>();

        // Creamos y lanzamos 7 coches (como pide el ejercicio).
        for (int i = 1; i <= 7; i++) {
            Thread t = new Thread(new Coche(aparcamiento, "Coche-" + i));
            hilos.add(t);
            t.start(); // Inicia el hilo del coche.
        }

        // Esperamos a que todos los coches terminen (opcional, pero ordenado).
        for (Thread t : hilos) {
            try {
                t.join(); // Espera a que el hilo termine.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Fue interrumpido.");
            }
        }

        // Mensaje final al terminar toda la simulación.
        System.out.println("Finalizada.");
    }
}
