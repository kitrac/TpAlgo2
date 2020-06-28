package red;

import mensaje.InfoReply;
import mensaje.InfoRequest;
import mensaje.PingReply;
import mensaje.PingRequest;

import java.util.List;

public abstract class Satelite extends Operador {

    private int velocidad;
    private int diametroVisible;

    public Satelite(int id, int velocidad, int altura, int diametroVisible) {
        super(id, altura);
        this.velocidad = velocidad;
        this.diametroVisible = diametroVisible;
    }

    //se agrega la arista de ida y vuelta "arista doble"
    public void addEdge(Operador destino) {
        Edge arista = new Edge(this, destino);
        this.getEdges().add(arista);

        Edge aristaVuelta = new Edge(destino, this);
        destino.getEdges().add(aristaVuelta);

        this.actualizarEstadoEdges();
    }

    public int getDiametroVisible() {
        return this.diametroVisible;
    }


    public void mover(int largoOrbita) {
        this.setPosicion(this.getPosicion() + this.velocidad);
        if (this.getPosicion() > largoOrbita) {
            this.setPosicion(0);
        }
        this.actualizarEstadoEdges();
        this.actualizarDistanciaEdge();
    }

    public void actualizarEstadoEdges() {
        List<Edge> edges = this.getEdges();
        for (Edge arista : edges) {
            boolean estado = this.dentroRango(arista.getDestino().getPosicion());
            arista.setEstado(estado);
            Edge aristaDestino = arista.getDestino().getAristaDestino(this.getId()); //aca obtengo la arista desde el lado del destino
            aristaDestino.setEstado(estado);
        }
    }

    public  void actualizarDistanciaEdge() {
        List<Edge> edges = this.getEdges();
        for (Edge arista : edges) {
            int distanciaX = Math.abs(this.getPosicion() - arista.getDestino().getPosicion());
            int distanciaY = Math.abs(this.getAltura() - arista.getDestino().getAltura());
            int distancia = (int) Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
            arista.setDistancia(distancia);
            Edge aristaDestino = arista.getDestino().getAristaDestino(this.getId()); //aca obtengo la arista desde el lado del destino
            aristaDestino.setDistancia(distancia);

        }
    }

    private boolean dentroRango(int posicion) {
        return this.getPosicion() - this.diametroVisible <= posicion && this.getPosicion() + this.diametroVisible >= posicion;
    }


    @Override
    public String toString() {
        return "Satelite id = " + this.getId() + " altura = " + this.getAltura() + " posicion = " + this.getPosicion() + " conexiones = " + this.getEdges() + "\n";
    }
}
