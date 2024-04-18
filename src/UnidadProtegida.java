import java.util.Random;

// Clase que representa una unidad protegida que decide qué línea de comunicación utilizar
class UnidadProtegida {
    private Linea lineaA;
    private Linea lineaB;
    private Linea lineaC;

    public UnidadProtegida(Linea lineaA, Linea lineaB, Linea lineaC) {
        this.lineaA = lineaA;
        this.lineaB = lineaB;
        this.lineaC = lineaC;
    }

    public void enviarMensaje(Mensaje mensaje) {
        Linea lineaSeleccionada;
        if (!lineaA.isSobrecargada()) {
            lineaSeleccionada = lineaA;
            mensaje.concatLine(" linea A");
        } else if (!lineaB.isSobrecargada()) {
            lineaSeleccionada = lineaB;
            mensaje.concatLine(" linea B");
        } else {
            lineaSeleccionada = lineaC;
            mensaje.concatLine(" linea C");
        }
        // Simulación de reencolado y envío de mensaje a la línea seleccionada
        System.out.println("Enviando mensaje '" + mensaje.getContenido() + "' por la línea seleccionada.");
    }
}
