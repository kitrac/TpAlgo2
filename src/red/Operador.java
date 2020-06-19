package red;

import mensaje.Mensaje;

import java.util.ArrayList;
import java.util.List;

public abstract class Operador {
    private final int id;
    private List<Edge> edges;
    private static List<Integer> listaIds = new ArrayList<>();
    private int posicion; //posicion en la orbita o tierra;

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

    public int getPosicion() {
        return this.posicion;
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


    //se agrega la arista de ida y vuelta "arista doble"
    public void addEdge(Operador destino, double distancia) {
        Edge arista = new Edge(this, destino, distancia);
        this.getEdges().add(arista);

        Edge aristaVuelta = new Edge(destino, this, distancia);
        destino.getEdges().add(aristaVuelta);
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
