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
    }

    public void addEdge(Estacion destino, int distancia) {
        Edge arista = new Edge(this, destino, distancia);
        this.getEdges().add(arista);
    }

    public boolean enviarMensaje(Red red, Mensaje mensaje) {

        Operador origen = mensaje.getOrigen();
        List<Operador> listaVecinos = origen.obtenerVecinos();

        int indexDestino = listaVecinos.indexOf(mensaje.getDestino());

        Operador vecino = listaVecinos.get(indexDestino);

        return true;
    }


    @Override
    public String toString() {
        return "Estacion id = " + this.getId() + " conexiones = " + this.getEdges() + "\n";
    }
}
