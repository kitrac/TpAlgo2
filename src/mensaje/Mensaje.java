package mensaje;

import contenido.Contenido;
import red.Operador;

public abstract class Mensaje {

    private String id;
    private Operador origen;
    private final Operador destino;
    private final Contenido contenido;
    private final Operador creador;


    public Mensaje(String id, Operador origen, Operador destino) {
        this.id = id;
        this.creador = origen;
        this.origen = origen;
        this.destino = destino;
        this.contenido = null;
    }

    public Mensaje(String id, Operador origen, Operador destino, Contenido contenido) {
        this.id = id;
        this.creador = origen;
        this.origen = origen;
        this.destino = destino;
        this.contenido = contenido;
    }

    public String getId() {
        return id;
    }

    public Operador getOrigen() {
        return origen;
    }

    public Operador getCreador() {
        return this.creador;
    }

    public Operador getDestino() {
        return destino;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setOrigen(Operador origen) {
        this.origen = origen;
    }

    public abstract void enviar();

    @Override
    public String toString() {
        return "" + this.id + " " + this.origen + " " + this.destino + " " + this.contenido;
    }
}
