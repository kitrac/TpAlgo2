package red;

import java.util.ArrayList;
import java.util.List;

public class Estructura {
    private final int id;
    private List<Edge> edges;

    public Estructura(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addEdge(Estructura destino, double distancia) {
        Edge arista = new Edge(this, destino, distancia);
        this.edges.add(arista);
    }

    @Override
    public String toString() {
        return "" + id + " " + edges;
    }
}
