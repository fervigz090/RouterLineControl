
public class RouterRed {
    public static void main(String[] args) {
        // Crear líneas de comunicación
        Linea lineaA = new Linea();
        Linea lineaB = new Linea();
        Linea lineaC = new Linea();

        // Crear tareas de servicio para controlar las líneas
        Thread tareaServicioA = new Thread(new TareaServicio(lineaA));
        Thread tareaServicioB = new Thread(new TareaServicio(lineaB));
        Thread tareaServicioC = new Thread(new TareaServicio(lineaC));

        // Iniciar tareas de servicio
        tareaServicioA.start();
        tareaServicioB.start();
        tareaServicioC.start();

        // Crear unidad protegida
        UnidadProtegida unidadProtegida = new UnidadProtegida(lineaA, lineaB, lineaC);

        // Simular envío de mensajes
        for (int i = 0; i < 10; i++) {
            Mensaje mensaje = new Mensaje("Mensaje " + (i + 1));
            unidadProtegida.enviarMensaje(mensaje);
            try {
                Thread.sleep(2000); // Simular intervalo entre mensajes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
