package red;

import javafx.scene.input.Mnemonic;
import mensaje.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Operador {
    private final int id;
    private List<Edge> edges;
    private static List<Integer> listaIds = new ArrayList<>();
    private int posicion; //posicion en la orbita o tierra;
    private List<Mensaje> consola;
    private int altura;

    public Operador(int id, int altura) {
        if (!Operador.listaIds.contains(id)) {
            this.id = id;
            Operador.listaIds.add(this.id);
            this.edges = new ArrayList<>();
            this.consola = new ArrayList<>();
            this.altura = altura;
        } else {
            this.id = -1; //aca va un error en realidad
        }
    }

    public int getId() {
        return id;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public List<Mensaje> getConsola() {
        return this.consola;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setPosicionInicial(int largoOrbita) {
        this.posicion = (int) (Math.random() * largoOrbita);
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Edge getAristaDestino(int id) {
        Edge aristaSeleccionada = null;
        for (Edge arista : this.edges) {
            if (arista.getDestino().getId() == id) {
                aristaSeleccionada = arista;
            }
        }
        return aristaSeleccionada;
    }

    public List<Operador> obtenerVecinos() {
        List<Operador> vecinos = new ArrayList<>();
        for (Edge arista : edges) {
            vecinos.add(arista.getDestino());
        }
        return vecinos;
    }

    public void enviarMensaje(PingRequest mensaje) {
        mensaje.enviar();
    }

    public void enviarMensaje(PingReply mensaje) {
        mensaje.enviar();
    }

    public void enviarMensaje(InfoRequest mensaje) {
        mensaje.enviar();
    }

    public void enviarMensaje(InfoReply mensaje) {
        mensaje.enviar();
    }


    public abstract void recibirMensaje(PingRequest mensaje);

    public abstract void recibirMensaje(PingReply mensaje);

    public abstract void recibirMensaje(InfoRequest mensaje);

    public abstract void recibirMensaje(InfoReply mensaje);


    @Override
    public String toString() {
        return "" + id + " " + edges;
    }
}
