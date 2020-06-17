package mensaje;

import red.Operador;

public class Mensaje {

    private final int id;
    private final Operador origen;
    private final Operador destino;
    private final String contenido;

    public Mensaje(int id, Operador origen, Operador destino, String contenido) {
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
