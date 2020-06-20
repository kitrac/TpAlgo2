package red;

public class Edge {

    private final Operador origen;
    private final Operador destino;
    private double distancia;
    private boolean estado;

    public Edge(Operador origen, Operador destino) {
        this.origen = origen;
        this.destino = destino;
        this.estado = true;
    }

    public Edge(Operador origen, Operador destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.estado = true;
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String toString() {
        return "Conexion [ Destino = " + this.destino.getId() + " Distancia = " + this.distancia + " Estado = " + this.estado + "]";
    }
}
