import java.util.Random;

// Clase que representa una tarea de servicio para controlar una línea de comunicación
class TareaServicio implements Runnable {
    private Linea linea;

    public TareaServicio(Linea linea) {
        this.linea = linea;
    }

    @Override
    public void run() {
        // Simulación de operaciones de administración
        try {
            Thread.sleep(new Random().nextInt(5000)); // Simular tiempo de operación
            linea.setSobrecargada(new Random().nextBoolean()); // Simular sobrecarga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
