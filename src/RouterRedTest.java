import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RouterRedTest {

    @Test
    public void testEnvioMensajes() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirigir salida estándar
        // Crear líneas de comunicación
        Linea lineaA = new Linea();
        Linea lineaB = new Linea();
        Linea lineaC = new Linea();

        // Establecer que la línea A no está sobrecargada
        lineaA.setSobrecargada(false);

        // Establecer que la línea B y C están sobrecargadas
        lineaB.setSobrecargada(true);
        lineaC.setSobrecargada(true);

        // Crear unidad protegida
        UnidadProtegida unidadProtegida = new UnidadProtegida(lineaA, lineaB, lineaC);

        // Mensaje a enviar
        Mensaje mensaje = new Mensaje("Mensaje de prueba");

        // Enviar mensaje
        unidadProtegida.enviarMensaje(mensaje);

        // Verificar que el mensaje se envió por la línea A
        assertEquals("Enviando mensaje 'Mensaje de prueba linea A' por la línea seleccionada.", outContent.toString().trim());

    }
}