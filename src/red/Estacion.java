package red;

import mensaje.Mensaje;
import orbitas.Orbita;

import java.util.List;

public class Estacion extends Operador {

    public Estacion(int id, int largoTierra) {
        super(id);
        this.setPosicionInicial(largoTierra);
    }

    public Mensaje generarMensaje(int id, Operador destino, String contenido) {
        return new Mensaje(id, this, destino, contenido);
    }

    public void addEdge(Satelite destino) {
        Edge arista = new Edge(this, destino, destino.getAltura());
        this.getEdges().add(arista);

        Edge aristaVuelta = new Edge(destino, this, destino.getAltura());
        destino.getEdges().add(aristaVuelta);
    }

    public void addEdge(Estacion destino, int distancia) {
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
