package mensaje;

import contenido.Contenido;
import red.Operador;

import java.util.ArrayList;
import java.util.List;

public abstract class Mensaje {

    private String id;
    private Operador origen;
    private final Operador destino;
    private final Contenido contenido;
    private List<Operador> recorrido;


    public Mensaje(String id, Operador origen, Operador destino) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.contenido = new Contenido(true);
        this.recorrido = new ArrayList<>();
    }

    public Mensaje(String id, Operador origen, Operador destino, Contenido contenido) {
        this.id = id;
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
        return this.recorrido.get(0);
    }

    public Operador getDestino() {
        return destino;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public List<Operador> getRecorrido() {
        return recorrido;
    }

    public void setOrigen(Operador origen) {
        this.origen = origen;
    }

    public void addOperadorRecorrido(Operador operador) {
        this.recorrido.add(operador);
    }

    public abstract void enviar();

    public abstract void reenviarMensaje();

    @Override
    public String toString() {
        return "" + this.id + " " + this.origen + " " + this.destino + " " + this.contenido;
    }


}
