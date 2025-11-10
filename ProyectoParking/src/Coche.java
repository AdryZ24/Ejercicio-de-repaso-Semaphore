import java.util.Random;

/**
 * Clase que representa un coche que intenta aparcar.
 * Cada coche es un hilo (Runnable) que compite por entrar al aparcamiento.
 */
public class Coche implements Runnable {

    // Referencia al aparcamiento compartido por todos los coches.
    private final Aparcamiento aparcamiento;

    // Nombre del coche (por ejemplo, "Coche-1").
    private final String nombre;

    // Objeto Random para generar tiempos aleatorios de aparcamiento.
    private final Random rnd = new Random();

    /**
     * Constructor que recibe el aparcamiento y el nombre del coche.
     */
    public Coche(Aparcamiento aparcamiento, String nombre) {
        this.aparcamiento = aparcamiento;
        this.nombre = nombre;
    }

    /**
     * Método run(): se ejecuta cuando el hilo (coche) empieza.
     * Intenta aparcar, espera un tiempo aleatorio y luego sale.
     */
    @Override
    public void run() {
        try {
            // El coche intenta entrar. Si no hay sitio, se queda esperando.
            aparcamiento.entrar(nombre);

            // Simulamos que el coche permanece aparcado entre 1 y 4 segundos.
            int tiempo = 1000 + rnd.nextInt(3000);
            Thread.sleep(tiempo);

        } catch (InterruptedException e) {
            // Si ocurre una interrupción mientras espera o duerme.
            System.out.println(nombre + " fue interrumpido mientras esperaba/aparcaba.");
            Thread.currentThread().interrupt();
        } finally {
            // Pase lo que pase, el coche libera la plaza al salir.
            aparcamiento.salir(nombre);
        }
    }
}
