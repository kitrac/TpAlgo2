package red;

import mensaje.Mensaje;

import java.util.ArrayList;
import java.util.List;

public abstract class Operador {
    private final int id;
    private List<Edge> edges;
    private static List<Integer> listaIds = new ArrayList<>();

    public Operador(int id) {
        if (!Operador.listaIds.contains(id)) {
            this.id = id;
            Operador.listaIds.add(this.id);
        } else {
            this.id = -1; //aca va un error en realidad
        }
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
