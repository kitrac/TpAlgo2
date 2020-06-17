package mensaje;

import red.Estructura;

public class Mensaje {

    private final int id;
    private final Estructura origen;
    private final Estructura destino;
    private final String contenido;

    public Mensaje(int id, Estructura origen, Estructura destino, String contenido) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "" + this.id + " " + this.origen + " " + this.destino + " " + this.contenido;
    }
}
