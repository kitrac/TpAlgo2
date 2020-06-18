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

    @Override
    public String toString() {
        return "" + id + " " + edges;
    }
}
