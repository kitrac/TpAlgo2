package red;

import mensaje.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class Operador {
    private final int id;
    private List<Edge> edges;

    public Operador(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Operador> obtenerVecinos() {
        List<Operador> vecinos = new ArrayList<>();

        for (Edge arista : edges) {
            vecinos.add(arista.getDestino());
        }

        return vecinos;
    }

    public void addEdge(Operador destino, double distancia) {
        Edge arista = new Edge(this, destino, distancia);
        this.edges.add(arista);
    }

    public boolean enviarMensaje(Red red, Mensaje mensaje) {

        Operador origen = mensaje.getOrigen();
        List<Operador> listaVecinos = origen.obtenerVecinos();

        boolean esVecino = listaVecinos.contains(mensaje.getDestino());

        for (Operador vecino : listaVecinos) {

        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id + " " + edges;
    }
}
