🚗 Control de Acceso Concurrente a un Aparcamiento (con Semaphore)
🧩 Descripción General

Este proyecto simula un aparcamiento con plazas limitadas al que intentan acceder varios coches al mismo tiempo.
Para controlar el acceso concurrente se utiliza la clase Semaphore de Java, que permite limitar cuántos hilos pueden acceder simultáneamente a un recurso compartido.

🎯 Objetivos del Ejercicio

Comprender el uso de la clase Semaphore en la gestión de recursos limitados.

Implementar sincronización entre hilos para controlar el acceso concurrente.

Simular un entorno real donde varios procesos (coches) compiten por recursos (plazas).

🧱 Estructura del Proyecto

El programa se compone de tres clases principales:

🔹 Aparcamiento.java

Representa el recurso compartido (el aparcamiento).

Usa un objeto Semaphore para limitar las plazas disponibles.

Solo permite que 3 coches aparquen al mismo tiempo.

Gestiona las entradas y salidas con mensajes por consola.

🔹 Coche.java

Representa cada coche como un hilo (Runnable).

Cada coche intenta aparcar, permanece un tiempo aleatorio (1–4 s) y luego sale.

Si el aparcamiento está lleno, el hilo espera hasta que haya espacio.

🔹 PrincipalParking.java

Es la clase principal del programa.

Crea el aparcamiento con capacidad para 3 coches.

Lanza 7 hilos (Coche-1 a Coche-7) para simular la concurrencia.

Espera a que todos los coches terminen antes de finalizar la simulación.

⚙️ Funcionamiento

Se crean 7 coches que intentan aparcar al mismo tiempo.

El Semaphore con 3 permisos permite que solo 3 coches estén dentro a la vez.

Los demás coches esperan su turno (quedan bloqueados en acquire()).

Cada coche ocupa su plaza durante un tiempo aleatorio entre 1 y 4 segundos.

Al salir, el coche libera su plaza (release()), permitiendo que otro entre.

Todo el proceso se muestra en consola, indicando cuántas plazas hay ocupadas.

🖥️ Ejemplo de Salida en Consola
Coche-1 ha entrado. Plazas ocupadas: 1 / 3
Coche-2 ha entrado. Plazas ocupadas: 2 / 3
Coche-3 ha entrado. Plazas ocupadas: 3 / 3
Coche-4 está esperando...
Coche-5 está esperando...
Coche-2 ha salido. Plazas ocupadas: 2 / 3
Coche-4 ha entrado. Plazas ocupadas: 3 / 3
Coche-1 ha salido. Plazas ocupadas: 2 / 3
...
Simulación finalizada.

🧠 Conceptos Clave

Semaphore: controla cuántos hilos pueden acceder a un recurso al mismo tiempo.

acquire(): el hilo intenta obtener un permiso (espera si no hay).

release(): libera un permiso cuando termina.

Sincronización: evita que más de 3 hilos accedan simultáneamente al recurso compartido.

Concurrencia controlada: demuestra cómo gestionar recursos escasos de forma segura.
