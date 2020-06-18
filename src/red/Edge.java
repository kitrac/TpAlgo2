package red;

public class Edge {

    private final Operador origen;
    private final Operador destino;
    private double distancia;

    public Edge(Operador origen, Operador destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public Operador getOrigen() {
        return origen;
    }

    public Operador getDestino() {
        return destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String toString() {
        return "Conexion [ Destino = " + this.destino.getId() + " Distancia = " + this.distancia + "]";
    }
}
