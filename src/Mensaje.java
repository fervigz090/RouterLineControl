// Clase que representa una petición de mensaje
class Mensaje {
    private String contenido;

    public Mensaje(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void concatLine(String linea) {
        this.contenido += linea;
    }
}
