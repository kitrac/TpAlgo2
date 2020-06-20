package red;

import java.util.List;

public class Satelite extends Operador {

    private int velocidad;
    private int altura;
    private int diametroVisible;

    public Satelite(int id, int velocidad, int altura, int diametroVisible) {
        super(id);
        this.velocidad = velocidad;
        this.altura = altura;
        this.diametroVisible = diametroVisible;
    }

    //se agrega la arista de ida y vuelta "arista doble"
    public void addEdge(Operador destino, double distancia) {
        Edge arista = new Edge(this, destino, distancia);
        this.getEdges().add(arista);

        Edge aristaVuelta = new Edge(destino, this, distancia);
        destino.getEdges().add(aristaVuelta);
    }

    public int getDiametroVisible() {
        return this.diametroVisible;
    }

    public int getAltura() {
        return this.altura;
    }


    public void mover(int largoOrbita) {
        this.setPosicion(this.getPosicion() + this.velocidad);
        if (this.getPosicion() > largoOrbita) {
            this.setPosicion(0);
        }
        this.actualizarEstadoEdges();
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

    private boolean dentroRango(int posicion) {
        return this.getPosicion() - this.diametroVisible < posicion && this.getPosicion() + this.diametroVisible > posicion;
    }


    @Override
    public String toString() {
        return "Satelite id = " + this.getId() + " altura = " + this.altura + " posicion = " + this.getPosicion() + " conexiones = " + this.getEdges() + "\n";
    }
}
