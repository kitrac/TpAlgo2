package red;

public class Edge {

    private final Estructura origen;
    private final Estructura destino;
    private double distancia;

    public Edge(Estructura origen, Estructura destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public Estructura getOrigen() {
        return origen;
    }

    public Estructura getDestino() {
        return destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String toString() {
        return "Edge [Origen = " + this.origen.getId() + " Destino = " + this.destino.getId() + " Distancia = " + this.distancia + "]";
    }
}
