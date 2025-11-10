import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que representa un aparcamiento con plazas limitadas.
 * Controla la entrada y salida de coches usando un Semaphore.
 */
public class Aparcamiento {

    // Semáforo que gestiona las plazas disponibles.
    private final Semaphore semaforo;

    // Contador de plazas ocupadas (solo informativo, para imprimir en consola).
    private final AtomicInteger plazasOcupadas = new AtomicInteger(0);

    // Capacidad máxima del aparcamiento.
    private final int capacidad;

    /**
     * Constructor: crea un aparcamiento con la capacidad indicada.
     * El semáforo se inicializa con el número de plazas disponibles.
     *
     * @param capacidad número máximo de coches que pueden aparcar a la vez.
     */
    public Aparcamiento(int capacidad) {
        this.capacidad = capacidad;

        // Creamos el semáforo con 'capacidad' permisos y en modo justo (true) para mantener el orden de llegada.
        this.semaforo = new Semaphore(capacidad, true);
    }

    /**
     * Método para que un coche intente entrar al aparcamiento.
     * Si no hay plazas libres, el hilo (coche) esperará hasta que alguien salga.
     */
    public void entrar(String nombreCoche) throws InterruptedException {
        // Si no quedan permisos en este momento, mostramos que el coche está esperando.
        if (semaforo.availablePermits() == 0) {
            System.out.println(nombreCoche + " está esperando...");
        }

        // El coche intenta adquirir un permiso (espera si no hay disponibles).
        semaforo.acquire();

        // Actualizamos el número de plazas ocupadas.
        int ocupadas = plazasOcupadas.incrementAndGet();

        // Mostramos el estado actual del aparcamiento.
        System.out.println(nombreCoche + "Entró. Plazas ocupadas: " + ocupadas + " / " + capacidad);
    }

    /**
     * Método para que un coche salga del aparcamiento y libere su plaza.
     */
    public void salir(String nombreCoche) {
        // Disminuimos el contador de plazas ocupadas.
        int ocupadas = plazasOcupadas.decrementAndGet();

        // Mostramos mensaje con el estado actualizado.
        System.out.println(nombreCoche + "Salió. Plazas ocupadas: " + ocupadas + " / " + capacidad);

        // Liberamos un permiso en el semáforo para que otro coche pueda entrar.
        semaforo.release();
    }
}
