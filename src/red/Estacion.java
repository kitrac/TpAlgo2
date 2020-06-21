package red;

import mensaje.*;

public class Estacion extends Operador {

    public Estacion(int id, int largoTierra) {
        super(id, 0);
        this.setPosicionInicial(largoTierra);
    }

    @Override
    public void recibirMensaje(PingRequest mensaje) {

    }

    @Override
    public void recibirMensaje(PingReply mensaje) {

    }

    @Override
    public void recibirMensaje(InfoRequest mensaje) {

    }

    @Override
    public void recibirMensaje(InfoReply mensaje) {

    }

    public Estacion(int id, int largoTierra, int altura) {
        super(id, altura);
        this.setPosicionInicial(largoTierra);
    }

    public void addEdge(Satelite destino) {
        Edge arista = new Edge(this, destino, destino.getAltura());
        this.getEdges().add(arista);

        Edge aristaVuelta = new Edge(destino, this, destino.getAltura());
        destino.getEdges().add(aristaVuelta);
    }

    public void addEdge(Estacion destino) {

        int distancia = Math.abs(destino.getPosicion() - this.getPosicion());
        Edge arista = new Edge(this, destino, distancia);
        this.getEdges().add(arista);
        Edge aristaVuelta = new Edge(destino, this, distancia);
        destino.getEdges().add(aristaVuelta);
    }


    @Override
    public String toString() {
        return "Estacion id = " + this.getId() + " conexiones = " + this.getEdges() + "\n";
    }
}
